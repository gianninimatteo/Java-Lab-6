plugins {
    java // Carica il necessario per la compilazione di Java
    application // Carica il necessario per l'esecuzione di classi con la JVM
}
application { // Configurazione dell'esecuzione, la main class è sufficiente
    mainClass.set("it.unibo.inheritance.test.TestBankAccount")
}
