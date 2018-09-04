let dumb_state = {
    crawl: () => {
        return "i don't know how to crawl"
    },
    walk: () => {
        return "i don't know how to walk"
    }
}

class Person {
    constructor(state) {
        this.crawl = state.crawl
        this.walk = state.walk
    }
}

let person = new Person(dumb_state)

console.log(person.crawl())
console.log(person.walk())

console.log()

person.crawl = () => {
    return "crawling"
}

person.walk = () => {
    return "walking"
}

console.log(person.crawl())
console.log(person.walk())
