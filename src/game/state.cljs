(ns game.state
  (:refer-clojure :exclude [get get-in])
  (:require [reagent.core :as reagent]
            [game.views.heroes :as default-view]
            [game.procedural.hero :refer [generate]]))

(defonce state
  (reagent/atom
    {:view default-view/main
     ;; the amount of gold the player has
     :gold 5000
     ;; all the heroes in the world
     :heroes (mapv generate (range 20))
     ;; the ids of the heroes the player owns
     :my-heroes (mapv #(rand-int 20) (range 3))}))

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
