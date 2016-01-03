(ns game.util.core)

(defn money-suffix [x]
  (let [m10 10000000
        k100 100000]
  (condp <= x
    m10  (str (js/parseFloat (.toFixed (/ x 1000000) 2)) "M")
    k100 (str (js/parseFloat (.toFixed (/ x 1000) 2)) "K")
    x)))

