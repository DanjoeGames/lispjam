(ns game.models.hero)

(def skins
  {:male [{:x 0 :y 0 :titles []}
          {:x 2 :y 0 :titles ["of the East"]}
          {:x 4 :y 0 :titles ["of the South"]}
          {:x 6 :y 0 :titles ["the Goblin"]}
          {:x 8 :y 0 :titles ["the Orc"]}]
   :female [{:x 1 :y 0 :titles []}
            {:x 3 :y 0 :titles ["of the East"]}
            {:x 5 :y 0 :titles ["of the South"]}
            {:x 7 :y 0 :titles ["the Goblin"]}
            {:x 9 :y 0 :titles ["the Orc"]}]})

(def hair
  {:male [{:x 0 :y 1 :titles ["the Brown"]}
          {:x 1 :y 1 :titles ["the Elder"]}
          {:x 2 :y 1 :titles ["the Ginger"]}
          {:x 3 :y 1 :titles ["the Fair"]}
          {:x 4 :y 1 :titles ["the Blue"]}
          {:x 5 :y 1 :titles ["the Holy"]}
          {:x 6 :y 1 :titles ["the Tribal"]}
          {:x 7 :y 1 :titles ["the Tribal"]}
          {:x 8 :y 1 :titles ["the Sad"]}
          {:x 9 :y 1 :titles []}]
   :female [{:x 0 :y 2 :titles ["the Brown"]}
            {:x 1 :y 2 :titles ["the Elder"]}
            {:x 2 :y 2 :titles ["the Ginger"]}
            {:x 3 :y 2 :titles ["the Fair"]}
            {:x 4 :y 2 :titles ["the Blue"]}
            {:x 5 :y 2 :titles ["the Holy"]}
            {:x 6 :y 2 :titles ["the Tribal"]}
            {:x 7 :y 2 :titles ["the Tribal"]}
            {:x 8 :y 2 :titles ["the Sad"]}
            {:x 9 :y 2 :titles []}]})

(def clothes
  {:male [{:x 0 :y 3 :titles []}
          {:x 1 :y 3 :titles []}
          {:x 2 :y 3 :titles []}
          {:x 3 :y 3 :titles []}
          {:x 4 :y 3 :titles []}
          {:x 5 :y 3 :titles []}
          {:x 6 :y 3 :titles []}
          {:x 7 :y 3 :titles []}
          {:x 8 :y 3 :titles []}
          {:x 9 :y 3 :titles []}]
   :female [{:x 0 :y 4 :titles []}
            {:x 1 :y 4 :titles []}
            {:x 2 :y 4 :titles []}
            {:x 3 :y 4 :titles []}
            {:x 4 :y 4 :titles []}
            {:x 5 :y 4 :titles []}
            {:x 6 :y 4 :titles []}
            {:x 7 :y 4 :titles []}
            {:x 8 :y 4 :titles []}
            {:x 9 :y 4 :titles []}]})

(def names
  {:color ["blue" "red" "black" "violet" "orange" "green" "amber"
           "grey" "yellow" "brown" "crimson"]
   ;; words that can describe a hero
   :adjective ["bright" "calm" "brave" "grim" "quick" "slow"
               "big" "small" "strong" "weak" "old" "young" "bold"]
   ;; title a hero can be given
   :title ["faithful" "enchantress" "nasty" "hellion" "wanderer" "unworthy"
           "deaf" "twisted" "magus" "scourge" "stony" "humble" "southener"
           "northerner" "kind" "jester" "devious" "miserable" "daring"
           "lucky" "crafty" "lucky" "unlucky" "fool" "hunter" "tormented"
           "bard" "assassin" "wizard" "spy" "insane" "careful" "raider"
           "corrupted" "adventurer" "rebel" "heretic" "elder" "swift"]
   ;; bastard names from asoiaf
   :landscape ["mountains" "rivers" "trees" "rocks" "sand" "snow" "storm"]
   ;; weather and general meteorological stuff
   :weather ["rain" "cloud" "sun" "thunder" "wind" "storm" "mist" "fog" "star"]
   ;; short metal names
   :metal ["iron" "steel" "gold" "silver" "bronze" "tin" "mithril"]
   ;; list of monsters (could pull this from another model later)
   :monster ["dragon" "ogre" "giant" "wolf" "spider" "troll" "wraith" "ghost"]
   ;; something the hero has been
   :deed ["slayer" "bane" "child"]
   ;; part of the heroes body
   :bodypart ["hand" "head" "eye" "foot" "chest" "tongue" "mouth" "heart"]
   ;; some condition of impairment
   :disfigured ["burned" "blackened" "scarred"]
   ;; list of pontential firstnames for the hero
   :firstname ["areon" "bela" "dayn" "balien" "quentin" "carstan" "dyl"
               "ester" "frederick" "george" "gerdan" "halast" "howl" "idris"
               "inders" "jevos" "joz" "kela" "kalad" "lythe" "liss" "lokk"
               "madran" "mors" "m'olloch" "nasthe" "nomst" "nanyl" "olyver"
               "olost" "periel" "pestir" "queyth" "radyr" "roderick" "reyl"
               "styven" "styrt" "tym" "tastar" "teize" "ulla" "verwick"
               "wylliam" "wull" "yathar" "z'olloch"]
   ;; start combining other parts to genreate surnames
   :surname [[:adjective :metal]
             [:weather :metal]
             [:adjective :bodypart]
             [:weather :bodypart]
             [:monster :deed]
             [:monster :bodypart]]
   ;; helper for adding the
   :the [" the "]
   ;; a set of default types that a name can take
   :name [[:firstname " " :surname]
          [:firstname " " :landscape]
          [:firstname :the :color]
          [:disfigured " " :firstname]
          [:firstname :the :title]
          [:firstname :the :adjective]
          [:firstname :the :surname]
          [:adjective " " :firstname]]})

