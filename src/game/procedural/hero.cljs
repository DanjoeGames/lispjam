(ns game.procedural.hero
  (:require [game.models.hero :refer [skins hair clothes]]))

(defn either [& args]
  (rand-nth args))

(defn one-of [args]
  (rand-nth args))

(defn generate []
  (let [gender (either :male :female)]
    {:gender gender
     :skin (one-of (get skins gender))
     :hair (one-of (get hair gender))
     :clothes (one-of (get clothes gender))
     :level (rand-int 100)
     :xp 0
     :hp 5
     :name "Hero"
     :items []}))

