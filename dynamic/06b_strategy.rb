class TaxCalculator
  attr_reader :input

  def initialize(input)
    @input = input
  end

  def calculate(taxing_amount, &strategy)
    return input if strategy.nil?

    strategy[input, taxing_amount]
  end
end


# Without any strategy, returns original input
print "returns original input: "
puts TaxCalculator.new(100).calculate(1231)

# We can define on the fly taxing strategies
print "returns additive taxing: "
puts TaxCalculator.new(20).calculate(30) { |i, t| i + t }

# We can store taxing strategies as classes that understand `to_proc`
# In this case, we could even have some initialization code to add more
# variables to the calculation.
class PercentageTaxStrategy
  def to_proc
    -> (i, t) { i * (1 + t) }
  end
end

print "returns percent additive taxing: "
puts TaxCalculator.new(100).calculate(0.21, &PercentageTaxStrategy.new)

# We can store taxing strategies as local procs
negative_taxing = -> (i, t) { i - t }

print "returns negative taxing: "
puts TaxCalculator.new(100).calculate(10, &negative_taxing)
