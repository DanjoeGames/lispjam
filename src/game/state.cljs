(ns game.state
  (:refer-clojure :exclude [get])
  (:require [reagent.core :as reagent]
            [game.views.heroes :as default-view]
            [game.procedural.hero :refer [generate]]))

(defonce state
  (reagent/atom
    {:view default-view/main
     :heroes (map generate (range 100))}))

(defn get [k & [default]]
  (clojure.core/get @state k default))

(defn put! [k v]
  (swap! state assoc k v))

(defn update-in! [ks f & args]
  (swap!
    state
    #(apply (partial update-in % ks f) args)))

(add-watch state :watcher (fn [_ _ oldv newv]
                            (println "State changed")))
