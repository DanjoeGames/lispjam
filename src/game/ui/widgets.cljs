(ns game.ui.widgets)

(defn item-slot [item] (let [itemImg (item :src) itemName (item :name)] 
  [:div [:img {:src itemImg} :p itemName]]))

(defn item-list [items]
  [:li (map (fn [item] [item]) items)])

