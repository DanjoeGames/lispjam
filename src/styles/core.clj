(ns styles.core
  (:require [garden.def :refer [defstylesheet defstyles]]
            [garden.units :refer [px]]))

(defstylesheet screen
  (css [:html :body {:font-family "CourneufRegular"
                     :margin 0}]))

