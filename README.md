# 📚 Design Patterns in Java

This repository contains implementations of various design patterns in Java, along with explanations of their benefits and drawbacks. Each design pattern is implemented with clear and concise examples to help understand its application.

## Table of Contents

- [Creational Patterns](#creational-patterns)
    - [Singleton](#singleton-pattern)
    - [Factory Method](#factory-method-pattern)
    - [Abstract Factory](#abstract-factory-pattern)
    - [Builder](#builder-pattern)
    - [Prototype](#prototype-pattern)
    - [Multiton](#multiton-pattern)
    - [Object Pool](#object-pool-pattern)
- [Structural Patterns](#structural-patterns)
    - [Adapter](#adapter-pattern)
    - [Bridge](#bridge-pattern)
    - [Composite](#composite-pattern)
    - [Decorator](#decorator-pattern)
    - [Facade](#facade-pattern)
    - [Flyweight](#flyweight-pattern)
    - [Proxy](#proxy-pattern)
- [Behavioral Patterns](#behavioral-patterns)
    - [Chain of Responsibility](#chain-of-responsibility-pattern)
    - [Command](#command-pattern)
    - [Interpreter](#interpreter-pattern)
    - [Iterator](#iterator-pattern)
    - [Mediator](#mediator-pattern)
    - [Memento](#memento-pattern)
    - [Observer](#observer-pattern)
    - [State](#state-pattern)
    - [Strategy](#strategy-pattern)
    - [Template Method](#template-method-pattern)
    - [Visitor](#visitor-pattern)

## Creational Patterns

### Singleton Pattern
The Singleton pattern ensures a class has only one instance and provides a global point of access to it.

**Pros:**
- Controlled access to the single instance.
- Reduced namespace pollution.
- Permits refinement of operations and representation.

**Cons:**
- Can be difficult to unit test.
- Can introduce global state into an application.

**Object-Oriented Principles:**
- **Encapsulation:** Ensures a single instance with a global access point.
- **Coupling:** Can lead to tightly coupled code due to the global state.
- **Cohesion:** High cohesion within the singleton instance.

### Factory Method Pattern
The Factory Method pattern defines an interface for creating an object but lets subclasses alter the type of objects that will be created.

**Pros:**
- Provides hooks for subclasses.
- Connects parallel class hierarchies.

**Cons:**
- Can complicate the code by requiring a hierarchy of Factory classes.

**Object-Oriented Principles:**
- **Open/Closed Principle:** Easy to extend with new product types without changing the client code.
- **Single Responsibility Principle:** The factory is responsible for creating objects, while the objects themselves are responsible for their own behavior.
- **Encapsulation:** Hides the instantiation logic from the client.

### Abstract Factory Pattern
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**Pros:**
- Ensures consistency among products.
- Promotes code decoupling.

**Cons:**
- Can be challenging to extend and change the interface.

**Object-Oriented Principles:**
- **Open/Closed Principle:** Easy to introduce new families of products without changing existing code.
- **Single Responsibility Principle:** Separates the product creation code from the business logic.
- **Encapsulation:** Hides the creation logic of families of products.

### Builder Pattern
The Builder pattern allows constructing complex objects step by step.

**Pros:**
- Allows for more control over the construction process.
- Improves readability of the client code.

**Cons:**
- Can be verbose with many parameters.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** The builder is responsible for constructing the product.
- **Open/Closed Principle:** Allows easy addition of new construction steps.
- **Encapsulation:** Hides the complex construction process from the client.

### Prototype Pattern
The Prototype pattern allows creating new objects by copying an existing object, known as the prototype.

**Pros:**
- Reduces the need for creating subclasses.
- Useful for creating objects with few differences.

**Cons:**
- Cloning complex objects that have circular references might be difficult.

**Object-Oriented Principles:**
- **Encapsulation:** Hides the cloning process from the client.
- **Single Responsibility Principle:** The prototype itself is responsible for creating a copy of itself.
- **Coupling:** Can lead to tightly coupled code if prototypes are not managed carefully.

### Multiton Pattern
The Multiton pattern ensures a class has only a limited number of instances and provides a global point of access to these instances.

**Pros:**
- Limits the number of instances.
- Provides controlled access to the instances.

**Cons:**
- Can introduce global state into an application.
- Can be difficult to unit test.

**Object-Oriented Principles:**
- **Encapsulation:** Ensures controlled access to a limited number of instances.
- **Coupling:** Can lead to tightly coupled code due to the global state.
- **Cohesion:** High cohesion within each instance.

### Object Pool Pattern
The Object Pool pattern manages a pool of reusable objects, reducing the overhead of creating and destroying objects.

**Pros:**
- Reduces the overhead of creating and destroying objects.
- Improves performance by reusing objects.

**Cons:**
- Can introduce complexity in managing the pool.
- Requires careful management of object state.

**Object-Oriented Principles:**
- **Encapsulation:** Manages the lifecycle of pooled objects.
- **Single Responsibility Principle:** The pool is responsible for managing the objects' lifecycle.
- **Cohesion:** High cohesion within the pool management logic.

## Structural Patterns

### Adapter Pattern
The Adapter pattern allows incompatible interfaces to work together.

**Pros:**
- Allows two incompatible interfaces to work together.
- Promotes reusability.

**Cons:**
- Can introduce unnecessary complexity.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** The adapter is responsible for converting the interface of a class.
- **Open/Closed Principle:** New adapters can be created to handle new interfaces without changing the existing code.
- **Encapsulation:** Hides the conversion logic from the client.

### Bridge Pattern
The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently.

**Pros:**
- Improves extensibility.
- Hides implementation details from clients.

**Cons:**
- Increases complexity by requiring two separate hierarchies.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Separates the abstraction from its implementation.
- **Open/Closed Principle:** New abstractions and implementations can be added independently.
- **Encapsulation:** Hides implementation details from the client.

### Composite Pattern
The Composite pattern allows treating individual objects and compositions of objects uniformly.

**Pros:**
- Makes it easier to add new kinds of components.
- Simplifies client code.

**Cons:**
- Can make the system overly general.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each component class is responsible for its own behavior.
- **Open/Closed Principle:** New components can be added without changing existing code.
- **Encapsulation:** Hides the details of how compositions of objects are created.

### Decorator Pattern
The Decorator pattern allows adding behavior to objects dynamically.

**Pros:**
- More flexible than static inheritance.
- Avoids feature-laden classes high up in the hierarchy.

**Cons:**
- Can result in many small objects in the system.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each decorator class is responsible for adding specific behavior.
- **Open/Closed Principle:** New decorators can be added without changing existing code.
- **Encapsulation:** Hides the details of how behaviors are combined.

### Facade Pattern
The Facade pattern provides a simplified interface to a complex subsystem.

**Pros:**
- Reduces complexity.
- Decouples subsystems from clients.

**Cons:**
- Can become a god object coupled to all classes in a subsystem.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** The facade is responsible for providing a simplified interface.
- **Open/Closed Principle:** New methods can be added to the facade without changing the subsystems.
- **Encapsulation:** Hides the complexity of the subsystems from the client.

### Flyweight Pattern
The Flyweight pattern allows sharing common parts of an object's state among multiple objects to save memory.

**Pros:**
- Reduces memory consumption.
- Simplifies complex models by sharing states.

**Cons:**
- Can introduce complexity in managing shared state.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each flyweight class is responsible for managing its own state.
- **Open/Closed Principle:** New flyweight objects can be added without changing existing code.
- **Encapsulation:** Hides the details of how state is shared.

### Proxy Pattern
The Proxy pattern provides a surrogate or placeholder for another object to control access to it.

**Pros:**
- Controls access to the real object.
- Can add additional functionalities.

**Cons:**
- Can introduce latency.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** The proxy is responsible for controlling access.
- **Open/Closed Principle:** New proxies can be added without changing existing code.
- **Encapsulation:** Hides the details of how access is controlled.

## Behavioral Patterns

### Chain of Responsibility Pattern
The Chain of Responsibility pattern allows passing requests along a chain of handlers.

**Pros:**
- Reduces coupling between sender and receiver.
- Adds flexibility in assigning responsibilities.

**Cons:**
- Can make it hard to observe the flow of requests.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each handler is responsible for processing specific requests.
- **Open/Closed Principle:** New handlers can be added without changing existing code.
- **Encapsulation:** Hides the details of how requests are processed.

### Command Pattern
The Command pattern encapsulates a request as an object, thereby allowing for parameterization and queuing of requests.

**Pros:**
- Decouples the object that invokes the operation from the one that knows how to perform it.
- Supports undoable operations.

**Cons:**
- Can result in a proliferation of command classes.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each command class is responsible for executing specific behavior.
- **Open/Closed Principle:** New commands can be added without changing existing code.
- **Encapsulation:** Hides the details of how requests are executed.

### Interpreter Pattern
The Interpreter pattern provides a way to evaluate language grammar or expressions.

**Pros:**
- Easy to change and extend the grammar.
- Implementing grammar is straightforward.

**Cons:**
- Can be inefficient for complex grammars.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each interpreter class is responsible for interpreting specific grammar rules.
- **Open/Closed Principle:** New grammar rules can be added without changing existing code.
- **Encapsulation:** Hides the details of how grammar is interpreted.

### Iterator Pattern
The Iterator pattern provides a way to access the elements of a collection without exposing its underlying representation.

**Pros:**
- Supports variations in the traversal of a collection.
- Simplifies the collection interface.

**Cons:**
- Additional complexity for creating iterator classes.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each iterator class is responsible for traversing specific collections.
- **Open/Closed Principle:** New iterators can be added without changing existing code.
- **Encapsulation:** Hides the details of how collections are traversed.

### Mediator Pattern
The Mediator pattern defines an object that encapsulates how a set of objects interact.

**Pros:**
- Reduces the dependencies between communicating objects.
- Centralizes control logic.

**Cons:**
- Can introduce a single point of failure.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** The mediator is responsible for coordinating communication.
- **Open/Closed Principle:** New mediators can be added without changing existing code.
- **Encapsulation:** Hides the details of how communication is coordinated.

### Memento Pattern
The Memento pattern captures and restores an object's internal state.

**Pros:**
- Provides a way to rollback changes.
- Preserves encapsulation boundaries.

**Cons:**
- Can consume a lot of memory if objects are large.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** The memento is responsible for storing state.
- **Open/Closed Principle:** New mementos can be added without changing existing code.
- **Encapsulation:** Hides the details of how state is stored.

### Observer Pattern
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified.

**Pros:**
- Promotes loose coupling.
- Provides support for broadcast communication.

**Cons:**
- Can lead to memory leaks if not handled properly.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each observer is responsible for updating based on state changes.
- **Open/Closed Principle:** New observers can be added without changing existing code.
- **Encapsulation:** Hides the details of how state changes are communicated.

### State Pattern
The State pattern allows an object to alter its behavior when its internal state changes.

**Pros:**
- Localizes state-specific behavior.
- Makes state transitions explicit.

**Cons:**
- Can result in a large number of classes for state objects.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each state class is responsible for specific behavior.
- **Open/Closed Principle:** New states can be added without changing existing code.
- **Encapsulation:** Hides the details of how state transitions are managed.

### Strategy Pattern
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.

**Pros:**
- Simplifies the algorithm selection process.
- Promotes the use of composition over inheritance.

**Cons:**
- Clients must be aware of different strategies.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each strategy class is responsible for specific behavior.
- **Open/Closed Principle:** New strategies can be added without changing existing code.
- **Encapsulation:** Hides the details of how algorithms are implemented.

### Template Method Pattern
The Template Method pattern defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

**Pros:**
- Promotes code reuse.
- Enforces a standard way to execute an algorithm.

**Cons:**
- Can lead to a rigid class hierarchy.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each subclass is responsible for specific steps of the algorithm.
- **Open/Closed Principle:** New steps can be added without changing the algorithm structure.
- **Encapsulation:** Hides the details of how steps are implemented.

### Visitor Pattern
The Visitor pattern allows adding new operations to a class hierarchy without changing the classes.

**Pros:**
- Makes adding new operations easy.
- Separates algorithm from object structure.

**Cons:**
- Can make the system harder to understand.

**Object-Oriented Principles:**
- **Single Responsibility Principle:** Each visitor class is responsible for specific operations.
- **Open/Closed Principle:** New operations can be added without changing the object structure.
- **Encapsulation:** Hides the details of how operations are applied.

## How to Use

1. Clone the repository.
2. Open the project in IDE.
3. Navigate to the package of the desired design pattern.
4. Run the main classes or client classes to see the pattern in action.
