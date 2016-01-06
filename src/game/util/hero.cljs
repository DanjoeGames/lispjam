(ns game.util.hero
  (:require [game.state :as state]))

(defn id->hero
  "Takes an id and returns the corresponding hero"
  [id]
  (nth (state/get :heroes) id))

(defn swap-hero!
  "Swaps a hero based on their id and a swap function
   as though they were an atom."
  [id f & args]
  (apply state/update-in!
         (conj '([:heroes id] f) args)))


