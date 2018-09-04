class MementoMixin(object):
    def __init__(self, *args, **kwargs):
        super(MementoMixin, self).__init__(*args, **kwargs)
        self.__MEMORY__ = []

    def __setattr__(self, field, value):
        if field != "__MEMORY__":
            self.__MEMORY__.append(
                {k: v for k, v in self.__dict__.items() if k != '__MEMORY__'}
            )
        super(MementoMixin, self).__setattr__(field, value)

    def replay(self):
        for state in self.__MEMORY__:
            replay_obj = self.__class__.__new__(self.__class__)
            replay_obj.__dict__.update(state)
            yield replay_obj


class Dog(MementoMixin):
    def __init__(self, name, *args, **kwargs):
        super(Dog, self).__init__(*args, **kwargs)
        self.name = name

    def bark(self):
        if hasattr(self, 'name'):
            return "{0} says: woof".format(self.name)
        return "woof"


dog = Dog("Goofy")
print(dog.bark())

dog.name = "Oddie"
print(dog.bark())

dog.name = "Scooby"
print(dog.bark())

print()

# This will replay all previous states before the last one.
for memented_dog in dog.replay():
    print(memented_dog.bark())
