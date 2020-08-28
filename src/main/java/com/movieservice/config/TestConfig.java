package com.movieservice.config;

import com.movieservice.models.*;
import com.movieservice.models.enums.RentStatus;
import com.movieservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class TestConfig implements CommandLineRunner,WebMvcConfigurer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private RentItemRepository rentItemRepository;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User(null,"Rodolfo", "Bispo", "09603275413","rodolfo@gmail.com","123456");
        User user2 = new User(null,"José", "Da Silva", "12345678911","bispo@gmail.com","123456");

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
                "1.600 de seus companheiros.","1917.jpg",2.50);
        Movie m4 = new Movie(null,"Sonic","Sonic, o porco-espinho azul mais famoso do mundo," +
                " se junta com os seus amigos para derrotar o terrível Doutor Eggman, um cientista louco que" +
                " planeja dominar o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs.",
                "sonic.jpg",4.0);
        Movie m5 = new Movie(null,"Espetacular Homem Aranha","Peter Parker está tentando saber mais sobre" +
                " sua origem. Ele encontra uma pasta que pertenceu ao seu pai e quer descobrir por que " +
                "seus pais desapareceram. Sua busca o leva a Oscorp e ao dr. Curt Connors, que tem como alterego " +
                "o letal Lagarto.", "espetacular-homem-aranha.jpg",8.5);
        Movie m6 = new Movie(null,"Homem de Ferro","Tony Stark é um industrial bilionário e inventor brilhante " +
                "que realiza testes bélicos no exterior, mas é sequestrado por terroristas que o forçam a construir uma arma devastadora. " +
                "Em vez disso, ele constrói uma armadura blindada e enfrenta seus sequestradores. " +
                "Ao voltar para os EUA, Stark aprimora a armadura e a utiliza para combater o crime.", "homem-de-ferro.jpg",6.0);
        Movie m7 = new Movie(null,"Como eu Era Antes de Você","A jovem e peculiar Louisa \"Lou\" Clark transita de emprego a emprego " +
                "para ajudar a sustentar sua família. Entretanto, sua atitude alegre é " +
                "testada quando se torna cuidadora de Will Traynor.", "before-you.jpg",3.4);

        Movie m8 = new Movie(null,"Os Croods","Família da pré-história vê sua caverna ser destruída. Depois disso, os Croods partem em uma" +
                " aventura em busca de um novo lugar para morar, liderados por um garoto muito imaginativo que lhes ajuda a desbravar um mundo inteiramente novo.", "the-croods.jpg",7.0);

        Stock s1 = new Stock(null,m1,0);
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


        Rent r1 = new Rent(null,new Date(),new Date(), RentStatus.RENTED,Instant.now(),null,user);
        Rent r2 = new Rent(null,new Date(),new Date(), RentStatus.RENTED,Instant.now(),null,user2);

        RentItem mi1 = new RentItem(r1, m1, 1, m1.getPrice());
        RentItem mi2 = new RentItem(r1, m2, 1, m2.getPrice());
        RentItem mi3 = new RentItem(r2, m1, 1, m1.getPrice());
        RentItem mi4 = new RentItem(r2, m2, 1, m2.getPrice());


        userRepository.saveAll(Arrays.asList(user,user2));
        productRepository.saveAll(Arrays.asList(m1,m2,m3,m4,m5,m6,m7,m8));
        rentRepository.saveAll(Arrays.asList(r1, r2));
        rentItemRepository.saveAll(Arrays.asList(mi1,mi2,mi3,mi4));




    }
}
