(ns game.util.player
  (:require [game.state :as state]
            [game.util.hero :refer [id->hero]]))

(defn owns-hero?
  "Returns true if player owns the hero with this id"
  [id]
  (contains? (state/get :player-heroes) id))

(defn has-enough-gold?
  "Returns true if player has >= x gold"
  [x]
  (println x "<=" (state/get :gold))
  (<= x (state/get :gold)))

(defn- add-hero!
  "Adds a hero to the player's list"
  [id]
  (println "Add hero" id)
  (let [heroes (state/get :player-heroes)]
    (println heroes (conj heroes id))
    (state/put! :player-heroes (conj heroes id))))

(defn- remove-hero!
  "Removes a hero from the player's list"
  [id]
  (state/update-in! [:player-heroes] remove #(not= id)))

(defn- add-gold!
  "Adds gold to the player's total"
  [x]
  (let [gold (state/get :gold)]
    (state/put! :gold (+ gold x))))

(defn- remove-gold!
  "Removes gold from the player's total"
  [x]
  (add-gold! (- x)))

(defn buy-hero!
  "Takes a hero id and attempts to purchase them"
  [id]
  (println (id->hero id))
  (let [hero (id->hero id)
        price (:cost hero)
        already-owns? (owns-hero? id)
        can-afford? (has-enough-gold? price)]
    (println can-afford? already-owns?)
    (when (and can-afford? (not already-owns?))
      (add-hero! id)
      (remove-gold! price))))

(defn sell-hero!
  "Sells a hero from a player's list"
  [id]
  (let [hero (id->hero id)
        price (:cost hero)
        player-owns? (owns-hero? id)]
    (when player-owns?
      (remove-hero! id)
      (add-gold! price))))

