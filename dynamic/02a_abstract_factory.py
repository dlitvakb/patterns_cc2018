class Factory(object):
    def __new__(self, name, *args, **kwargs):
        klass = globals().get(name, None)
        if klass is None:
            raise Exception("Class {0} not found".format(name))
        return klass(*args, **kwargs)


class A(object):
    def foo(self):
        return "I'm A"


class B(object):
    def foo(self):
        return "I'm B"


a_instance = Factory("A")
b_instance = Factory("B")

print(a_instance.foo())

print()

print(b_instance.foo())

print()

try:
    c_instance = Factory("C")
except Exception as e:
    print(e)
