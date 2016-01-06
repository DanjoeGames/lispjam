(ns game.state
  (:refer-clojure :exclude [get get-in])
  (:require [reagent.core :as reagent]
            [game.procedural.hero :as hero]
            [game.procedural.monster :as monster]))

(defonce state
  (reagent/atom
    {:view :heroes
     :heroes (map hero/generate (range 100))
     :monsters (map monster/generate (range 100))}))

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
