public class Data {
    public static final int NBCOLONNE = 87;
    public static final int NBLIGNE = 87;
    public static final int TAILLECELLULE = 7;
    public boolean[][] tableauCelulles = new boolean[NBLIGNE][NBCOLONNE];
    private boolean[][] tableauTampon = new boolean[NBLIGNE][NBCOLONNE];

    public int nbGeneration;

    Data() {
        randomiserData();
        //test();
    }

    public void randomiserData() {
        int nbTrue = 0;
        int nbFalse = 0;
        int nbRandom;
        for (int i = 0; i < NBLIGNE; i++) {
            for (int j = 0; j < NBCOLONNE; j++) {
                nbRandom = 1 + (int) (Math.random() * (2 - 1 + 1));
                if (nbRandom == 1) {
                    tableauCelulles[i][j] = true;
                    nbTrue++;
                } else if (nbRandom == 2) {
                    tableauCelulles[i][j] = false;
                    nbFalse++;
                }
            }
        }
        System.out.println("Nombre true : " + nbTrue + " Nombre false : " + nbFalse);
    }

    public void test() {
        for(int i=0;i<tableauCelulles.length;i++) {
            for(int j=0;j<tableauCelulles.length;j++) {
                tableauCelulles[i][j] =true;
            }

        }

    }

    public void inverserCellule() {
        for (int i = 0; i < tableauCelulles.length; i++) {
            for (int j = 0; j < tableauCelulles.length; j++) {
                if (tableauCelulles[i][j] == true) {
                    tableauCelulles[i][j] = false;
                } else {
                    tableauCelulles[i][j] = true;
                }
            }
        }
    }

    public void calculGeneration() {
        nbGeneration++;
        int nbCelullesVivante;
        for (int i = 0; i < tableauCelulles.length; i++) {
            for (int j = 0; j < tableauCelulles.length; j++) {
                tableauTampon[i][j] = tableauCelulles[i][j];
            }
        }
        for (int i = 0; i < tableauCelulles.length; i++) {
            for (int j = 0; j < tableauCelulles.length; j++) {
                nbCelullesVivante = 0;
                if ((i != 0) && (j != 0) && (i != tableauCelulles.length - 1) && (j != tableauCelulles.length - 1)) {
                    if (tableauCelulles[i - 1][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i - 1][j]) nbCelullesVivante++;
                    if (tableauCelulles[i - 1][j + 1]) nbCelullesVivante++;
                    if (tableauCelulles[i][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i][j + 1]) nbCelullesVivante++;
                    if (tableauCelulles[i + 1][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i + 1][j]) nbCelullesVivante++;
                    if (tableauCelulles[i + 1][j + 1]) nbCelullesVivante++;
                    if (nbCelullesVivante >= 4) {
                        tableauTampon[i][j] = false;
                    } else if (nbCelullesVivante > 2) {
                        tableauTampon[i][j] = true;
                    } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                        tableauTampon[i][j] = true;
                    } else {
                        tableauTampon[i][j] = false;
                    }
                } else if (i == 0 && j == 0) {
                    if (tableauCelulles[i][j + 1]) nbCelullesVivante++;
                    if (tableauCelulles[i + 1][j]) nbCelullesVivante++;
                    if (tableauCelulles[i + 1][j + 1]) nbCelullesVivante++;
                    if (nbCelullesVivante >= 4) {
                        tableauTampon[i][j] = false;
                    } else if (nbCelullesVivante > 2) {
                        tableauTampon[i][j] = true;
                    } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                        tableauTampon[i][j] = true;
                    } else {
                        tableauTampon[i][j] = false;
                    }
                } else if (i == 0) {
                    if (j == tableauCelulles.length - 1) {
                        if (tableauCelulles[i][j - 1]) nbCelullesVivante++;
                        if (tableauCelulles[i + 1][j]) nbCelullesVivante++;
                        if (tableauCelulles[i + 1][j - 1]) nbCelullesVivante++;
                        if (nbCelullesVivante >= 4) {
                            tableauTampon[i][j] = false;
                        } else if (nbCelullesVivante > 2) {
                            tableauTampon[i][j] = true;
                        } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                            tableauTampon[i][j] = true;
                        } else {
                            tableauTampon[i][j] = false;
                        }
                    } else {
                        if (tableauCelulles[i][j - 1]) nbCelullesVivante++;
                        if (tableauCelulles[i + 1][j - 1]) nbCelullesVivante++;
                        if (tableauCelulles[i + 1][j]) nbCelullesVivante++;
                        if (tableauCelulles[i + 1][j + 1]) nbCelullesVivante++;
                        if (tableauCelulles[i][j + 1]) nbCelullesVivante++;
                        if (nbCelullesVivante >= 4) {
                            tableauTampon[i][j] = false;
                        } else if (nbCelullesVivante > 2) {
                            tableauTampon[i][j] = true;
                        } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                            tableauTampon[i][j] = true;
                        } else {
                            tableauTampon[i][j] = false;
                        }
                    }
                } else if (j == 0) {
                    if (i == tableauCelulles.length - 1) {
                        if (tableauCelulles[i - 1][j]) nbCelullesVivante++;
                        if (tableauCelulles[i - 1][j + 1]) nbCelullesVivante++;
                        if (tableauCelulles[i][j + 1]) nbCelullesVivante++;
                        if (nbCelullesVivante >= 4) {
                            tableauTampon[i][j] = false;
                        } else if (nbCelullesVivante > 2) {
                            tableauTampon[i][j] = true;
                        } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                            tableauTampon[i][j] = true;
                        } else {
                            tableauTampon[i][j] = false;
                        }
                    } else {
                        if (tableauCelulles[i - 1][j]) nbCelullesVivante++;
                        if (tableauCelulles[i - 1][j + 1]) nbCelullesVivante++;
                        if (tableauCelulles[i][j + 1]) nbCelullesVivante++;
                        if (tableauCelulles[i + 1][j + 1]) nbCelullesVivante++;
                        if (tableauCelulles[i - 1][j]) nbCelullesVivante++;
                        if (nbCelullesVivante >= 4) {
                            tableauTampon[i][j] = false;
                        } else if (nbCelullesVivante > 2) {
                            tableauTampon[i][j] = true;
                        } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                            tableauTampon[i][j] = true;
                        } else {
                            tableauTampon[i][j] = false;
                        }
                    }
                } else if (i == tableauCelulles.length - 1 && j == tableauCelulles.length - 1) {
                    if (tableauCelulles[i - 1][j]) nbCelullesVivante++;
                    if (tableauCelulles[i - 1][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i][j - 1]) nbCelullesVivante++;
                    if (nbCelullesVivante >= 4) {
                        tableauTampon[i][j] = false;
                    } else if (nbCelullesVivante > 2) {
                        tableauTampon[i][j] = true;
                    } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                        tableauTampon[i][j] = true;
                    } else {
                        tableauTampon[i][j] = false;
                    }
                } else if (i == tableauCelulles.length - 1) {
                    if (tableauCelulles[i][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i - 1][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i - 1][j]) nbCelullesVivante++;
                    if (tableauCelulles[i - 1][j + 1]) nbCelullesVivante++;
                    if (tableauCelulles[i][j + 1]) nbCelullesVivante++;
                    if (nbCelullesVivante >= 4) {
                        tableauTampon[i][j] = false;
                    } else if (nbCelullesVivante > 2) {
                        tableauTampon[i][j] = true;
                    } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                        tableauTampon[i][j] = true;
                    } else {
                        tableauTampon[i][j] = false;
                    }
                } else if (j == tableauCelulles.length - 1) {
                    if (tableauCelulles[i - 1][j]) nbCelullesVivante++;
                    if (tableauCelulles[i - 1][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i + 1][j - 1]) nbCelullesVivante++;
                    if (tableauCelulles[i + 1][j]) nbCelullesVivante++;
                    if (nbCelullesVivante >= 4) {
                        tableauTampon[i][j] = false;
                    } else if (nbCelullesVivante > 2) {
                        tableauTampon[i][j] = true;
                    } else if (nbCelullesVivante == 2 && tableauCelulles[i][j] == true) {
                        tableauTampon[i][j] = true;
                    } else {
                        tableauTampon[i][j] = false;
                    }
                }
            }
        }
        for (int i = 0; i < tableauCelulles.length; i++) {
            for (int j = 0; j < tableauCelulles.length; j++) {
                tableauCelulles[i][j] = tableauTampon[i][j];
            }
        }
        System.out.println("Nombre generation : "+nbGeneration);
    }

    public void reset() {
        for(int i=0;i< tableauCelulles.length;i++) {
            for(int j=0;j< tableauCelulles.length;j++) {
                tableauCelulles[i][j]=false;
            }
        }
    }
}

