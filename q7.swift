// by Mohammad Mahdi Malmasi




let input = readLine()

var numberOfFlowers: Int = 0
var numberOfMounts: Int = 0

if let input = input {
    let inputNumberCharacters = input.split(separator: " ")
    let numbers = inputNumberCharacters.map { Int(String($0))! }
    numberOfFlowers = numbers[0]
    numberOfMounts = numbers[1]
}

var counters = Array(repeating: 0, count: numberOfFlowers)

for _ in 1...numberOfMounts
{
    let mount: String = readLine()!
    var index = 0
    for c in mount
    {
        if (c == "W")
        {
            counters[index] += 1
        }
        index += 1
    }
}



for i in counters
{
    if (i%2 == 0)
    {
        print("B", terminator:"")
    }
    else
    {
        print("F", terminator:"")
    }
}





