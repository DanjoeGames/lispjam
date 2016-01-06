(ns game.state
  (:refer-clojure :exclude [get get-in])
  (:require [reagent.core :as reagent]
            [game.config :as config]
            [game.procedural.hero :as hero]
            [game.procedural.monster :as monster]))

(defonce state
  (reagent/atom
    {:view config/initial-view
     ;; initial population of heroes
     :heroes (mapv hero/generate
                   (range config/initial-hero-count))
     ;; initial population of monsters
     :monsters (mapv monster/generate
                     (range config/initial-monster-count))
     ;; initial gold for the player
     :gold config/initial-player-gold
     ;; store player heroes
     :player-heroes #{}
     ;; store player items
     :inventory #{}}))

(defn get [k & [default]]
  (clojure.core/get @state k default))

(defn get-in [ks & [default]]
  (clojure.core/get-in @state ks default))

(defn put! [k v]
  (swap! state assoc k v))

(defn update-in! [ks f & args]
  (swap!
    state
    #(apply (partial update-in % ks f) args)))

(add-watch state :watcher (fn [_ _ oldv newv]
                            (println "State changed")))
