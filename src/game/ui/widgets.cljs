(ns game.ui.widgets)

(defn item-slot [item] (let [itemImg (item :src) itemName (item :name)] 
  [:div {:style {"display" "inline"} :title itemName} [:img {:width "50" :height "50" :src itemImg}]]))

(defn item-slot-element [item] [:li {:style {"display" "inline"}}(item-slot item)])

(defn item-list [items]
  [:ul {:style {"list-style-type" "none"} :class "itemList"} (map item-slot-element items)])

(defn bar-block[]
  [:li {:style {"display" "inline"}}
   [:div {:style {"display" "inline"}}[:img {:width "20px" :height "20px" :src "assets/heart.png"}]]])

(defn hp-bar [current maximum]
  [:ul {:style {"list-style-type" "none"} :class "statusBar.hp"} 
   (map bar-block (range maximum))])


