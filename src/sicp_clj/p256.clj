(ns sicp-clj.p256
  (:require [sicp-clj.scheme :refer :all]))

(defn variable? [x]
  (symbol? x))

(defn same-variable? [x y]
  (and (variable? x)
       (variable? y)
       (eq? x y)))

(defn make-sum [x y]
  (list '+ x y))

(defn make-product [x y]
  (list '* x y))

(defn sum? [x]
  (and (pair? x)
       (eq? (car x) '+)))

(defn augend [x]
  (cadr x))

(defn addend [x]
  (caddr x))

(defn product? [x]
  (and (pair? x)
       (eq? (car x) '*)))

(defn multiplicand [x]
  (cadr x))

(defn multiplier [x]
  (caddr x))

(defn exponentiation? [x]
  (and (pair? x)
       (eq? (car x) '**)))

 (defn base [x]
   (cadr x))

(defn exponent [x]
  (caddr x))

(defn make-exponentiation [x y]
  (cond
    (eq? y 0) 1
    (eq? y 1) x
    (and (number? x) (number? y)) (expt x y)
    :else (list ('** x y))))

(defn deriv [exp var]
  (cond
    (number? exp) 0
    (variable? exp) (if (same-variable? exp var) 1 0)
    (sum? exp) (make-sum (deriv (addend exp) var)
                         (deriv (augend exp) var))
    (product? exp) (make-sum (make-product (multiplier exp)
                                           (deriv (multiplicand exp) var))
                             (make-product (deriv (multiplier exp) var)
                                           (multiplicand exp)))
    (exponentiation? exp)
      (make-product (exponent exp)
                    (make-product (make-exponentiation (base exp) (- (exponent exp) 1))
                                  (deriv (base exp) var)))
    :else (println "unknown expression type -- DERIV" exp)))

(defn solution []
  (println (deriv '(+ x 3) 'x))
  (println (deriv '(* x y) 'x)))
