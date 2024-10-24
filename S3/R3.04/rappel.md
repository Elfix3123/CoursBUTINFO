# Const :
| | | |
|-|-|-|
| `const int *p` | `p` modifiable | `*p` non modifiable |
| `int * const p` | `p` non modifiable | `*p` modifiable |

# Coplien :
```
Groupe();
Class(const Class &class);
Class &operator=(const Class &class);
~Class();
```

# Agregation et composition :
| Cardinalite     | 1 | 0..1 | * |
|-|-|-|-|
| Agregation | `Class c` | `Class *c;` `delete c;` | `std::Vector<Class> c;` |
| Composition | `Class &c;` | `Class *c` | `std::Vector<Class *> c;` |

# Pattern composite
## Component
```
class Element {
	virtual function() = 0;
};
```

## Leaf
```
class Leaf {
	function() override;
};
```

## Composite
```
class Composite {
	function() override;
	add(Component &c);
	remove(Component &c);
	getChild(std::Vector<Component> c);
};
```

# Templates
```
template <class T>
class Class {
	function();
};

template <class T>
Class<T>::function() {

}
```

# Exceptions
```
class MyException : public std::exception {
	public:
	MyException() {};
	virtual const char *what() const noexcept = 0;
};

class MyInheritedException : public MyException {
	public:
	MyInheritedException() {};
	virtual const char *what() const noexcept override {return "Description";};
};
```

# Testing
```
class Fixture : public testing::Test {
	protected:
	Fixture() : TestClass(arguments) {};

	void SetUp() override {};
	void TearDown() override {};
	
	TestClass c;
};

TEST_F(Fixture, TestedMethod) {

}
```
