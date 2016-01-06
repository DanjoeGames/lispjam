(require 'cljs.build.api)

(cljs.build.api/build "src" {:output-to "main.js"})
