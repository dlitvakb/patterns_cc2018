class NamingProxy
  def initialize(instance)
    @instance = instance
  end

  def respond_to_missing?(name, *args, &block)
    @instance.respond_to?(name, *args, &block)
  end

  def method_missing(name, *args, &block)
    "#{@instance.class.name} says: #{@instance.public_send(name, *args, &block)}"
  end
end

class Dog
  def bark
    "woof"
  end

  def walk
    "walking"
  end
end

proxy = NamingProxy.new(Dog.new)

# This will output "Dog says: woof"
puts proxy.bark

puts

puts proxy.walk

# This will raise an exception that Dog (not NamingProxy) doesn't respond to the method
puts proxy.foo
