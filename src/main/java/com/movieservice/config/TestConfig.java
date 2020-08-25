package com.movieservice.config;

import com.movieservice.models.*;
import com.movieservice.repositories.MovieItemRepository;
import com.movieservice.repositories.MovieRepository;
import com.movieservice.repositories.RentRepository;
import com.movieservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

@Configuration
public class TestConfig implements CommandLineRunner,WebMvcConfigurer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private MovieItemRepository movieItemRepository;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User(null,"Rodolfo","09603275413","rodolfo@gmail.com","123456");
        User user2 = new User(null,"Bispo","09603275213","bispo@gmail.com","123456");
        userRepository.saveAll(Arrays.asList(user,user2));

        Movie m1 = new Movie(null,"O homem Aranha 3","relacionamento entre Peter Parker e M.J." +
                " parece estar dando certo, mas outros problemas começam a surgir. " +
                "A roupa de Homem-Aranha torna-se preta e acaba controlando Peter," +
                " que apesar de aumentar seus poderes, revela o lado obscuro de sua personalidade." +
                " Os vilões Venon e Homem-Areia tentam destruir o super-herói.","homem-aranha-3.jpg",2.0);
        Movie m2 = new Movie(null,"A era do Gelo","Vinte mil anos atrás, num mundo coberto de gelo," +
                " o mamute Manfred e a preguiça Sid resgatam um bebê humano órfão. Agora," +
                " os dois vão enfrentar muitas aventuras até devolver o filhote de gente " +
                "à sua tribo, que migrou para um novo acampamento.","era-do-gelo.jpg",3.0);
        Movie m3 = new Movie(null,"1917","Na Primeira Guerra Mundial, dois soldados" +
                " britânicos recebem ordens aparentemente impossíveis de cumprir. Em uma corrida contra o tempo, " +
                "eles precisam atravessar o território inimigo e entregar uma mensagem que pode salvar " +
                "1.600 de seus companheiros.","1917.jpg",5.0);
        Movie m4 = new Movie(null,"Sonic","Sonic, o porco-espinho azul mais famoso do mundo," +
                " se junta com os seus amigos para derrotar o terrível Doutor Eggman, um cientista louco que" +
                " planeja dominar o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs.",
                "sonic.jpg",9.90);
        Movie m5 = new Movie(null,"Espetacular Homem Aranha","Peter Parker está tentando saber mais sobre" +
                " sua origem. Ele encontra uma pasta que pertenceu ao seu pai e quer descobrir por que " +
                "seus pais desapareceram. Sua busca o leva a Oscorp e ao dr. Curt Connors, que tem como alterego " +
                "o letal Lagarto.", "espetacular-homem-aranha.jpg",7.50);
        Movie m6 = new Movie(null,"Homem de Ferro","Tony Stark é um industrial bilionário e inventor brilhante " +
                "que realiza testes bélicos no exterior, mas é sequestrado por terroristas que o forçam a construir uma arma devastadora. " +
                "Em vez disso, ele constrói uma armadura blindada e enfrenta seus sequestradores. " +
                "Ao voltar para os EUA, Stark aprimora a armadura e a utiliza para combater o crime.", "homem-de-ferro.jpg",8.20);
        Movie m7 = new Movie(null,"Como eu Era Antes de Você","A jovem e peculiar Louisa \"Lou\" Clark transita de emprego a emprego " +
                "para ajudar a sustentar sua família. Entretanto, sua atitude alegre é " +
                "testada quando se torna cuidadora de Will Traynor.", "before-you.jpg",2.99);

        Movie m8 = new Movie(null,"Os Croods","Família da pré-história vê sua caverna ser destruída. Depois disso, os Croods partem em uma" +
                " aventura em busca de um novo lugar para morar, liderados por um garoto muito imaginativo que lhes ajuda a desbravar um mundo inteiramente novo.", "the-croods.jpg",2.99);

        Stock s1 = new Stock(null,m1,5);
        Stock s2 = new Stock(null,m2,10);
        Stock s3 = new Stock(null,m3,36);
        Stock s4 = new Stock(null,m4,7);
        Stock s5 = new Stock(null,m5,2);
        Stock s6 = new Stock(null,m6,48);
        Stock s7 = new Stock(null,m7,13);
        Stock s8 = new Stock(null,m8,1);
        m1.setStock(s1);
        m2.setStock(s2);
        m3.setStock(s3);
        m4.setStock(s4);
        m5.setStock(s5);
        m6.setStock(s6);
        m7.setStock(s7);
        m8.setStock(s8);

        movieRepository.saveAll(Arrays.asList(m1,m2,m3,m4,m5,m6,m7,m8));

        Rent rent = new Rent(null, Instant.now(),user);
        Rent rent2 = new Rent(null, Instant.now(),user2);
        rentRepository.saveAll(Arrays.asList(rent,rent2));

        MovieItem mi1 = new MovieItem(rent, m1, 1, m1.getRent_price());
        MovieItem mi2 = new MovieItem(rent, m2, 1, m2.getRent_price());
        MovieItem mi3 = new MovieItem(rent2, m1, 1, m1.getRent_price());
        MovieItem mi4 = new MovieItem(rent2, m2, 1, m2.getRent_price());

        movieItemRepository.saveAll(Arrays.asList(mi1,mi2,mi3,mi4));

    }
}
