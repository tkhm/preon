# Preon

A library for handling binary encoded data using Java.

Think of Preon as JAXB or Jackson/Gson for converting between structured binary data and Java objects.

Using a simple declarative syntax with annotations, Preon does the heavy lifting and lets you concentrate on the content
instead of having to worry about bitwise shifting, XOR-ing and ANDing.

You can finally put down the soldering iron.

**NOTE**

Preon was originally written by Wilfred Springer and the source code of its last official release (1.1) can
be found [here](https://github.com/preon/preon). Unfortunately, the original author has moved on and there have been no
changes to the codebase for quite some time - and the project will not build anymore out of the box.

This is an attempt to pull Preon into the present, and it is still work in progress.

At the moment, the following modules are up and running:

* preon-binding: the Preon "core" - binding annotations and codecs
* preon-el: a simple expression language ("Limbo") used in the binding annotations for runtime evaluation of field 
lengths, references etc.
* preon-io: tools for dealing with bitwise data using the buffers and channels design known from Java NIO

Support for creating documentation of bindings using `Pecia` has been dropped due to the fact that a current
implementation couldn't be found anywhere. Also I didn't see this as the most important feature - documentation support
_might_ be reintroduced in the future.

