(ns game.procedural.monster
  (:require [game.models.monsters :as monsters]))

(defn generate []
  (rand-nth monsters/all))
