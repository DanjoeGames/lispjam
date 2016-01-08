(ns game.procedural.monster
  (:require [game.models.monsters :as monsters]
            [game.models.items :as items]))

(defn generate []
  (let [monster (rand-nth monsters/all)]
    (assoc monster :weapon (rand-nth items/weapons)
           :armour (rand-nth items/armor))))
