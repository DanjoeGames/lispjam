# lispjam
Fantasy Hero Manager in Clojurescript

## Overview
Using Clojurescript with Reagent to build a game for Lisp Jam 2016.

## Setup
To get an interactive development environment run:

```bash
lein figwheel

# with history support and line editing
rlwrap lein figwheel
```

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

```clojurescript
(js/alert "Am I connected?")
```

and you should see an alert in the browser window.

To clean all compiled files:

```bash
lein clean
```

To create a production build run:

```bash
lein cljsbuild once min
```

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2016

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
