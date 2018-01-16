(ns sicp-clj.p253
  (:require [sicp-clj.scheme :refer :all]))

(defn memq [item x]
  (cond
    (empty? x) false
    (= item (car x)) x
    :else (memq item (cdr x))))

(defn solution []
  (println (list 'a 'b 'c))
  (println (list 'george))
  (println (car '((x1 x2) (y1 y2))))
  (println (cadr '((x1 x2) (y1 y2))))
  (println (pair? (car '(a short list))))
  (println (memq 'red '((red shoes) (blue socks))))
  (println (memq 'red '(red shoes blue socks))))
