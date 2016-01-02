(ns game.ui.widgets)

(defn item-slot [item] (let [itemImg (item :src) itemName (item :name)] 
  [:div {:title itemName} [:img {:src itemImg}]]))

(defn item-slot-element [item] [:li (item-slot item)])

(defn item-list [items]
  [:ul (map item-slot-element items)])

