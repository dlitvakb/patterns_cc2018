class EventObserverRegistry(object):
    __OBSERVERS__ = {}

    @classmethod
    def register(cls, event, observer, fn):
        if event not in cls.__OBSERVERS__:
            cls.__OBSERVERS__[event] = {}
        cls.__OBSERVERS__[event][observer] = fn

    @classmethod
    def emit(cls, event):
        cls().signal(event)

    def signal(self, event):
        if event in self.__class__.__OBSERVERS__:
            for observer, fn in self.__class__.__OBSERVERS__[event].items():
                getattr(observer, fn)()


def emit(event):
    EventObserverRegistry.emit(event)


class ContextEmitter(object):
    def __init__(self, event):
        self.event = event

    def __enter__(self):
        emit('entering_context_for_{0}'.format(self.event))

    def __exit__(self, *args, **kwargs):
        emit('exiting_context_for_{0}'.format(self.event))


class signal(object):
    def __init__(self, event):
        self.event = event

    def __call__(self, fn=None):
        def wrapper(observed=None):
            emit(self.event)
            if fn:
                return fn(observed)
        return wrapper


class Observed(object):
    @signal('before_doing_it')
    def do_something(self):
        print('doing_it')
        emit('after_doing_it')

        with ContextEmitter('foo'):
            print('something in the content')


class Observer(object):
    def __init__(self):
        EventObserverRegistry.register('before_doing_it', self, 'before')
        EventObserverRegistry.register('after_doing_it', self, 'after')
        EventObserverRegistry.register(
            'entering_context_for_foo', self, 'before_context'
        )
        EventObserverRegistry.register(
            'exiting_context_for_foo', self, 'after_context'
        )

    def before(self):
        print('observing before')

    def after(self):
        print('observing after')

    def before_context(self):
        print('observing before context')

    def after_context(self):
        print('observing after context')


observer = Observer()

observed = Observed()
observed.do_something()
