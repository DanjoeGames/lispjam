(ns game.procedural.hero
  (:require [game.models.hero :refer [skins hair clothes names]]))

(defn either [& args]
  (rand-nth args))

(defn one-of [args]
  (rand-nth args))

(defn interpolate
  "Takes a vector of symbols and strings and resolves it in model"
  [form]
    (cond
      (keyword? form) (interpolate (rand-nth (get names form)))
      (vector? form)  (apply str (map interpolate form))
      (string? form)  form))

(defn capitalize
  "Capitalize each word in a string"
  [name]
    (->> (.split name " ")
         (map clojure.string/capitalize)
         (interpose " ")
         (apply str)))

(defn make-name
  "Generate a name for a hero"
  ([]     (make-name [:name]))
  ([form] (capitalize (interpolate form))))

(defn generate []
  (let [gender (either :male :female)
        level (rand-int 100)]
    {:gender gender
     :name (make-name)
     :skin (one-of (get skins gender))
     :hair (one-of (get hair gender))
     :clothes (one-of (get clothes gender))
     :level level
     :cost (* (rand-int 10000) level)
     :xp 0
     :hp 5
     :items []}))

