<%@ page import="java.util.*, com.google.gson.Gson" %>
<%@ page import="stat.StatNombreclients" %>
<%@ page import="pack.Pack" %>
<%@ page import="pagination.Pagination" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<Pack> packList = (List<Pack>) request.getAttribute("pack");
    int currentPage = (int) request.getAttribute("currentPage");
    int totalPages = (int) request.getAttribute("totalPages");

    Pagination pagination = new Pagination();
    pagination.setTotalEnregistrements(totalPages * 2);
    pagination.setTotalParPage(2);
    pagination.setClassesCSS("pagination-sm");
    pagination.setUrl("TraitementPack");

    pagination.setPageActuelle(String.valueOf(currentPage));
    
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proposition</title>
    <link rel="stylesheet" href="assets/css/header.css">
    <link rel="stylesheet" href="assets/css/proposition.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="assets/css/pagination.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    

  
</head>

<body>
    <div class="conatiner">
        <header>
            <nav class="navigation">
                <a href="" class="logo">
                    <img src="assets/images/logo.png" alt="logo" />
                </a>
                <ul class="nav_menu">
                    <li class="nav_list">
                        <a href="#!" class="nav_link">Acceuil</a>
                    </li>
                    <li class="nav_list">
                        <a href="#!" class="nav_link">Partenaires</a>
                    </li>
                    <li class="nav_list">
                        <a href="#!" class="nav_link">Services</a>
                    </li>
                    <li class="nav_list">
                        <a href="#!" class="nav_link">A propos</a>
                    </li>
                    <li class="nav_list">
                        <a href="#!" class="nav_link">Aide</a>
                    </li>
                </ul>
                <div class="lien">
                    <div class="artenaire">
                        <li class="input btn-action">
                            <a href="" class="nav_link">S'inscire en tant que Partenaire</a>
                        </li>
                    </div>
                    <div class="connecter">
                        <li class="input btn-action">
                            <a href="" class="nav_link">S'inscire</a>
                        </li>
                        <li class="input btn-action">
                            <a href="" class="nav_link">Se connecter</a>
                        </li>
                    </div>
                </div>
            </nav>
        </header>
        <main>
            <div class="main-content">
                <div class="titre">
                    <h1>Proposition Pack</h1>
                </div>
                <div class="proposition">
                    <form action="TraitementPack" method="post">
                        <div class="budget">
                            <label for="">Votre budget</label>
                            <input type="number" name="budget" id="budget">
                        </div>

                        <div class="combien">
                            <label for="">Ville</label>
                            <input type="text" name="ville" id="ville">
                        </div>
                        
                        <div class="combien">
                            <label for=""></label>
                            <a href="TraitementMap" class="styled-link"><img src="assets/images/location.png" alt=""></a>
                        </div>

                        

                        <div class="proposer">
                            <input type="submit" value="Proposer">
                        </div>
                    </form>
                </div>
                <div class="suggestions">
                    <div class="titre">
                        <h1>Suggestions</h1>
                    </div>
                    
                    <div class="card-suggestions">
                    <%
                        if (packList != null) {
                        for (Pack pack : packList) {
                    %>
                        <div class="card">
                            <div class="image">
                                <img src="assets/images/rectangle_1291.jpeg" alt="">
                            </div>
                            <div class="name-suggestion">
                                
                                <div class="etoile">
                                    <i class="fas fa-star"></i>
                                    <label for=""> 4.9</label>
                                </div>
                            </div>
                            <div class="explorer">
                                <h2>Pack Explorer <%= pack.getVille() %></h2>
                            </div>
                            <div class="logos">
                                <div class="hotel">
                                    <i class="fa fa-hotel"></i>
                                    <label for=""><%= pack.getNombre_hotels() %> Hotel(s)</label>
                                </div>
                                <div class="transport">
                                    <i class="fas fa-bus"></i>
                                    <label for=""><%= pack.getNombre_transports() %> Transport(s)</label>
                                </div>
                                <div class="guide">
                                    <i class="fas fa-user"></i>

                                    <label for=""><%= pack.getNombre_guides() %> Guide(s)</label>
                                </div>
                                <div class="activite">
                                    <i class="fas fa-user"></i>
                                    <label for=""><%= pack.getNombre_attractions() %>Activite(s)</label>
                                </div>
                            </div>
                            <div class="activites">
                                
                                </label>
                            </div>
                            <div class="prix">
                                <h1><%= pack.getPrix_total() %> MGA</h1>
                                <li class="details">
                                    <a href="" class="nav_link">Details</a>
                                </li>
                            </div>
                        </div>
                        <%
                            }
                            }
                        %>
                    </div>
                    
                </div>

                <nav aria-label="Page navigation" class="pagination-container">
                    <ul class="pagination">
                        <%= pagination.paginationNumerique() %>
                    </ul>
                </nav>
            
            </div>
        </main>
        <footer>
            <div class="principal">
                <div class="form-input">
                    <div class="input">
                        <label for="">Language</label>
                        <select name="" id="">
                            <option value="">Francais</option>
                            <option value="">Malgache</option>
                            <option value="">Anglais</option>
                            <option value="">Francais</option>
                        </select>
                    </div>
                    <div class="input">
                        <label for="">Devise</label>
                        <select name="" id="">
                            <option value="">Mga</option>
                            <option value="">Euro</option>
                            <option value="">Dollar</option>
                        </select>
                    </div>
                    <div class="details">
                        <input type="button" value="Details">
                    </div>
                </div>
                <div class="content">
                    <div class="companie">
                        <h1>Compagnie</h1>
                        <p>Accueil</p>
                        <p>Partenaires</p>
                        <p>A propos</p>
                    </div>
                    <div class="service">
                        <h1>Services</h1>
                        <p>Proposition pack</p>
                        <p>Recherche de destination</p>
                        <p>Evaluation voyage</p>
                    </div>
                    <div class="Aides">
                        <h1>Aides</h1>
                        <p>Connectez-vous</p>
                        <p>Termes et condition d'utilisation</p>
                    </div>
                    <div class="methode_de_paiement">
                        <h1>Methode de paiement</h1>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <p>Copyright 2024 Abeona. All Rights Reserved</p>
            </div>
        </footer>
    </div>
</body>

</html>
<script>
        document.addEventListener('DOMContentLoaded', function() {
            var currentPage = <%= currentPage %>; // Récupérez la page actuelle côté serveur
            var paginationLinks = document.querySelectorAll('.pagination a');

            paginationLinks.forEach(function(link) {
                if (parseInt(link.innerHTML) === currentPage) {
                    link.classList.add('active');
                }
            });
        });
</script>