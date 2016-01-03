(ns game.ui.widgets
  (:require [reagent.core :as reagent]
            [secretary.core :refer [dispatch!]]
            [game.util.core :as util]))

(defn button
  "Creates a button and passes props down to child
   elements. Also takes text and an optional color
   where color is red, blue, green, yellow"
  [text props color]
    (let [color (or color "default")
          css-class (str "btn" " " "btn--" color)]
      [:div (merge props {:class css-class})
        [:div {:class "ui btn__left"}]
        [:div {:class "ui btn__middle"} text]
        [:div {:class "ui btn__right"}]]))

(defn icon
  "Wrapper around generic icon type uses the appropriate
   CSS class and attaches a given suffix in order to
   style as an icon"
  [icon-name]
    [:div {:class (str "icon" " " icon-name)}])

(defn pill [& children]
  [:div {:class "pill"}
   [:div {:class "ui pill__left"}]
   [:div {:class "ui pill__middle"}
    children]
   [:div {:class "ui pill__right"}]])

(defn overlay
  "Fullscreen translucent overlay, good for doing modals.
   Expects a showing prop in props map which determines
   whether to render it or not."
  [props & children]
    (if (:showing? props)
      [:div {:class "overlay"}
       [:div {:class "overlay__children"} children]]
      nil))

(defn level
  "Display a numeric level with the appropriate colouring"
  [x]
    [:span {:class (condp < x
                     100 "level--high"
                     50 "level--med"
                     20 "level--low"
                     "level--noob")} x])

(defn scroll
  "A scroll interface for showing text or controls onscreen"
  [& children]
    [:div {:class "scroll"}
     [:div {:class "ui scroll__top"}]
     [:div {:class "ui scroll__middle"} children]
     [:div {:class "ui scroll__bottom"}]])

(defn xp-orb
  "Renders a full/empty xp orb icon depending on full?"
  [full?]
    [icon (if full? "xp-orb--full" "xp-orb--empty")])

(defn xp-bar
  "Renders an XP bar of with y orbs. x orbs will
   be coloured and the rest will be empty."
  [x y]
    [:div {:class "icon-bar"}
     [:strong "XP"]
     (->> (repeat x true) (map xp-orb))
     (->> (repeat (- y x) false) (map xp-orb))])

(defn heart
  "Renders a full/empty heart icon depending on full?"
  [full?]
    [icon (if full? "heart--full" "heart--empty")])

(defn hp-bar
  "Renders an HP bar of with y hearts. x hearts will
   be coloured and the rest will be empty."
  [x y]
    [:div {:class "icon-bar"}
     [:strong "HP"]
     (->> (repeat x true) (map heart))
     (->> (repeat (- y x) false) (map heart))])

(defn money
  "Renders money with the appropriate color and suffix"
  [x]
    (let [amount (condp < x
                   1000000 "amount--huge"
                   100000 "amount--large"
                   10000 "amount--big"
                   "amount--small")]
      [:span {:title (str x " gold")}
        [icon "gold"]
        [:strong {:class amount} (util/money-suffix x)]]))

(defn navbar
  "Renders a navbar and accepts children to be rendered
   inside it"
  [title]
    [:nav {:class "ui navbar"}
     [pill [money 110044]]
     [pill [:h2 title]]
     [pill [level 300]]])

(defn help-button []
  (let [showing? (reagent/atom false)
        show! #(reset! showing? true)
        hide! #(reset! showing? false)]
    (fn []
      [:span
       [button [icon "help"] {:on-click show!}]
       [overlay {:showing? @showing?}
        [scroll
         [:h2 "Help"]
         [:hr]
         [:p "If you're reading this then we haven't
              got round to implementing help yet."]
         [:p "Sorry! Maybe you'll be able to figure
              it out on your own."]
         [:hr]
         [button "Ok!" {:on-click hide!} "yellow"]]]])))

(defn action-button [{text :text url :url color :color}]
  [button
   text
   {:on-click #(dispatch! url)}
   color])

(defn action-bar []
  (let [actions [{:text "Heroes" :url "/"       :color "yellow"}
                 {:text "Hunt"   :url "/hunt"   :color "red"}
                 {:text "League" :url "/league" :color "blue"}
                 {:text "Shop"   :url "/shop"   :color "green"}]]
    [:div {:class "ui action-bar"}
     (map action-button actions)
     [help-button]]))

(defn cycler [& children]
  (let [index (reagent/atom 0)
        limit (count children)]
    (fn []
      [:span {:on-click #(swap! index inc)}
        (get (vec children) (mod @index limit))])))

(defn horizontal-preview [left right]
  [:div {:class "hz-preview"}
   [:div {:class "hz-preview__left"}
    [:div {:class "ui hz-preview__left__top"}]
    [:div {:class "ui hz-preview__left__middle"}
     [left]]
    [:div {:class "ui hz-preview__left__bottom"}]]
   [:div {:class "hz-preview__right"}
    [:div {:class "ui hz-preview__right__top"}]
    [:div {:class "ui hz-preview__right__middle"}
     [right]]
    [:div {:class "ui hz-preview__right__bottom"}]]])

