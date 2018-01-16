(ns sicp-clj.p254
  (:require [sicp-clj.scheme :refer :all]))

(defn solution []
  (println (equal? '(this is a list) '(this is a list)))
  (println (equal? '(this is a list) '(this (is a) list))))
