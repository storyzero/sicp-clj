(ns sicp-clj.p255
  (:require [sicp-clj.scheme :refer :all]))

(defn solution []
  (println (car ''abracadabra))
  (println (car '(quote abracadabra))))
