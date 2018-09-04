class BasicIterator(object):
    """ This is any object which redefines the `__iter__`
        duck-typed interface """
    def __init__(self, items):
        self.items = items

    def __iter__(self):
        for item in self.items:
            yield item

    # if we want to be able to modify items here,
    # we need to also redefine `__getitem__`, `__setitem__`,
    # `__delitem__`, `append`, etc.
    def __getitem__(self, index):
        return self.items[index]

    def __setitem__(self, index, value):
        self.items[index] = value

    def __delitem__(self, index):
        del self.items[index]

    def append(self, value):
        return self.items.append(value)


class ListIterator(list):
    """ This is just a list in which
        we can append any behaviour we want
        The only caveat is that the list of elements,
        is self. """
    def evens(self):
        return [x for x in self if x % 2 == 0]


input("Basic Iterator")

input("iterates through the list and prints all elements\n")
basic_iterator = BasicIterator([1, 2, 3, 4])
for x in basic_iterator:
    print(x)

input("\nprints element at index 0\n")
print(basic_iterator[0])

input("\nadds an element to the list and prints it\n")
basic_iterator.append(5)
print(basic_iterator[4])

input("\ndeletes an element in the list\n")
print(basic_iterator.items)
del basic_iterator[4]
print(basic_iterator.items)

input("\nList Iterator\n")

input("iterates through the list and prints all elements\n")
list_iterator = ListIterator([1, 2, 3, 4])
for x in list_iterator:
    print(x)

input("\nprints element at index 0\n")
print(list_iterator[0])

input("\nadds an element to the list and prints it\n")
list_iterator.append(5)
print(list_iterator[4])

input("\ndeletes an element in the list\n")
print(list_iterator)
del list_iterator[4]
print(list_iterator)

input("\ncan easily call user defined behaviour\n")
for even in list_iterator.evens():
    print(even)
