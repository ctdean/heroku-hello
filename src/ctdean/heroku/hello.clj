;;;;
;;;; hello - a simple hello world web server
;;;;
;;;; Chris Dean

(ns ctdean.heroku.hello
  (:use noir.core hiccup.core)
  (:require [noir.server :as server]))

;; The only page
(defpage "/" []
  "<html><body>Hello world</body></html>")

;; The entry point for Heroku
(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "5000"))]
    (server/start port {:mode mode
                        :ns 'ctdean.heroku.hello})))

