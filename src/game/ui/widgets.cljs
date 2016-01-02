(ns game.ui.widgets)

(defn item-slot [item] (let [itemImg (item :src) itemName (item :name)] 
  [:div [:img {:src itemImg}] [:p itemName]]))

(defn item-list [items]
  [:li (map (fn [item] [item]) items)])

(defn xp-orb [k lit?]
  (let [color (if lit? "blue" "grey")]
    [:span {:key k :style {:color color }} "●"]))

(defn xp-bar [max-xp current]
  (let [empty-orbs (- max-xp current)]
    [:div
     [:strong "XP"]
      [:span
       (map-indexed xp-orb (repeat current true))]
      [:span
       (map-indexed xp-orb (repeat empty-orbs false))]]))

