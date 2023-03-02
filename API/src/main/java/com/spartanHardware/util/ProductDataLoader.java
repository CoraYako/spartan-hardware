package com.spartanHardware.util;


import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Component
@RequiredArgsConstructor
public class ProductDataLoader implements CommandLineRunner {

    private final IProductService productService;

    @Override
    public void run(String... args) throws Exception {
    //    loadProductsData();
    }

    private void loadProductsData() {
        ProductRequestDto notebook1 = ProductRequestDto.builder()
                .name("Notebook Dell Inspiron 3515 15.5, AMD Ryzen 5, AMD Radeon RX Vega 8, Windows 11 Home")
                .brand("Dell")
                .model("Inspiron 3515")
//                .images()
                .category("Notebook")
                .subCategory("Oficina")
                .shortDescription("Notebook Dell Inspiron 3515 plateada 15.5, AMD Ryzen 5 3450U 8GB de RAM 256GB SSD, " +
                        "AMD Radeon RX Vega 8 (Ryzen 2000/3000) 1366x768px Windows 11 Home")
                .description("Los equipos Dell se destacan por ofrecer soluciones reales para cada una de las necesidades. " +
                        "Ya sea para conectarte, entretenerte, trabajar o colaborar de manera online, " +
                        "podrás hacerlo de forma segura desde cualquier lugar y en cualquier momento. " +
                        "Pantalla con gran impacto visual " +
                        "Su pantalla LCD de 15.5 pulgadas y 1366x768 px de resolución te brindará colores más vivos y definidos. " +
                        "Tus películas y series preferidas cobrarán vida, ya que ganarán calidad y definición en cada detalle. " +
                        "Eficiencia a tu alcance " +
                        "Su procesador AMD Ryzen 5 de 4 núcleos, te permitirá ejecutar programas variados y procesos " +
                        "indispensables para desenvolverte en el día a día, ya sea en tu trabajo " +
                        "o en los momentos de ocio en tu hogar. " +
                        "Potente disco sólido " +
                        "El disco sólido de 256 GB hace que el equipo funcione a gran velocidad y por lo tanto " +
                        "te brinda mayor agilidad para operar con diversos programas. " +
                        "Un procesador exclusivo para los gráficos " +
                        "Su placa de video AMD Radeon RX Vega 8 (Ryzen 2000/3000) convierte a este dispositivo en una " +
                        "gran herramienta de trabajo para cualquier profesional del diseño. " +
                        "Te permitirá lograr una gran performance en todos tus juegos y en otras tareas cotidianas " +
                        "que impliquen procesamiento gráfico.")
                .recommended(TRUE)
                .price(229999.00)
                .specialPrice(189999.00)
                .quantity(10)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto notebook2 = ProductRequestDto.builder()
                .name("Notebook I5 Acer Nitro 5 Intel Core 256 Gb Ssd 8 Gb Ram")
                .brand("Acer")
                .model("Nitro 5")
//                .images()
                .category("Notebook")
                .subCategory("Gamer")
                .shortDescription("Acer Nitro 5 i5-11400H Notebook 39.6 cm (15.6 pulgadas) " +
                        "Full HD Intel Core i5 8 GB DDR4-SDRAM 256 GB SSD " +
                        "NVIDIA GeForce GTX 1650 Wi-Fi 6 (802.11ax) Windows 11 Home Black")
                .description("Un nuevo nivel de juego es posible con esta notebook Acer Aspire Nitro 5 AN515-54, " +
                        "porque te permite explorar y disfrutar de una mejor calidad de video " +
                        "y de imágenes más inmersivas. Enfrentá de cada partida y superá tus objetivos. " +
                        "Pantalla con gran impacto visual: " +
                        "Su pantalla LED de 15.6 y 1920x1080 px de resolución te brindará colores más vivos y definidos. " +
                        "Tus películas y series preferidas cobrarán vida, ya que ganarán calidad y definición en cada detalle. " +
                        "Su procesador Intel Core i5 de 4 núcleos, está pensado para aquellas personas generadoras y " +
                        "consumidoras de contenidos. Con esta unidad central, la máquina llevará a cabo varios procesos " +
                        "de forma simultánea, desde edición de videos hasta retoques fotográficos con programas profesionales. " +
                        "El disco sólido de 256 GB hace que el equipo funcione a gran velocidad y por lo tanto te brinda " +
                        " mayor agilidad para operar con diversos programas. " +
                        "Su placa de video NVIDIA GeForce GTX 1650 convierte a este dispositivo en una gran " +
                        "herramienta de trabajo para cualquier profesional del diseño. Te permitirá lograr una " +
                        "gran performance en todos tus juegos y en otras tareas cotidianas que impliquen procesamiento gráfico. " +
                        "La batería de este equipo tiene una autonomía de alrededor de 8 horas. La duración varía según " +
                        "el uso, la configuración y otros factores, pero vas a poder usarla durante varias horas " +
                        "sin depender de los enchufes.")
                .recommended(TRUE)
                .price(299999.00)
                .specialPrice(249999.00)
                .quantity(9)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto notebook3 = ProductRequestDto.builder()
                .name("MSI Thin GF63 Core i5 8GB de RAM 512GB SSD GTX 1650")
                .brand("MSI")
                .model("Thin GF63")
//                .images()
                .category("Notebook")
                .subCategory("Gamer")
                .shortDescription("Notebook gamer MSI Thin GF63 negra 15.6 pulgadas, Intel Core i5 10300H 8GB de RAM " +
                        "512GB SSD, NVIDIA GeForce GTX 1650 Max-Q 60 Hz 1920x1080px Windows 10 Home")
                .description("El más adaptable al cambio es el que sobrevive y evoluciona. " +
                        "Elige el espíritu del dragón y evoluciona con los últimos portátiles GF63 Thin de MSI Gaming " +
                        "equipados con procesadores Intel® Core i5 10500H, RAM DDR4 de 8 GB y tarjetas gráficas NVIDIA GeForce GTX 1650 Max-Q " +
                        "diseñadas para jugadores con estilo. Su pantalla IPS de 60hz ofrece una claridad sin precedentes con " +
                        "imágenes más vibrantes para que nunca pierdas el ritmo. Almacena lo que necesites con sus 256 GB " +
                        "y la posibilidad de expandir mediante puerto PCIe 3.0 NVMe. Trabaja y gestiona tu vida con lo último " +
                        "en OS que ofrece Microsoft: Windows 11 Home Basic.")
                .recommended(TRUE)
                .price(285890.00)
                .quantity(3)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto notebook4 = ProductRequestDto.builder()
                .name("Asus X515ea Intel Core I3 1115g4 4gb De Ram 256gb Ssd Intel Uhd")
                .brand("Asus")
                .model("X515ea")
//                .images()
                .category("Notebook")
                .subCategory("Oficina")
                .shortDescription("Notebook Asus X515ea Gris 15.6 , Intel Core I3 1115g4 4gb De Ram 256gb Ssd, " +
                        "Gráficos Intel Uhd 1366 × 768px Hd Freedos")
                .description("Ya sea para trabajar o jugar, ASUS Vivobook 15 X515 es una computadora portátil que " +
                        "ofrece un potente rendimiento y efectos visuales envolventes. " +
                        "Su pantalla NanoEdge cuenta con amplios ángulos de visión de 178 y un revestimiento mate " +
                        "antideslumbrante para una experiencia verdaderamente atractiva. En el interior, " +
                        "funciona con un procesador Intel Core i3 con diversas capacidades de RAM desde 4 GB " +
                        "y cuenta con un diseño que permite almacenamiento SSD PCIe, " +
                        "lo que le brinda velocidades rápidas de lectura / escritura de datos. " +
                        "Con un peso total de solo 1,8 kg, el ASUS X515 es el portátil liviano " +
                        "que se adapta a un estilo de vida vertiginoso.")
                .recommended(TRUE)
                .price(148999.00)
                .quantity(20)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto notebook5 = ProductRequestDto.builder()
                .name("Notebook Lenovo I5-1235u 512gb Ssd 8gb 15.6 Win11 Pro")
                .brand("Lenovo")
                .model("I5-1235u")
//                .images()
                .category("Notebook")
                .subCategory("Oficina")
                .shortDescription("Notebook Lenovo I5-1235u 512gb Ssd 8gb 15.6 Win11 Pro")
                .description("Lenovo IdeaPad 3 15IAU7 15.6 pulgadas i5-1235U/8GB/512GB SSD Laptop Lenovo IdeaPad 3 " +
                        "i5-1235U Notebook 39.6 cm (15.6) Full HD Intel® Core™ i5 8 GB DDR4-SDRAM 512 GB SSD " +
                        "Wi-Fi 6 (802.11ax).")
                .recommended(TRUE)
                .price(269599.00)
                .quantity(8)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto mouse1 = ProductRequestDto.builder()
                .name("Mouse gaming Soul Master Player XM 1000")
                .brand("Lenovo")
                .model("I5-1235u")
//                .images()
                .category("Notebook")
                .subCategory("Oficina")
                .shortDescription("Para trabajar desde casa con la computadora o aprovechar los momentos de ocio, " +
                        "necesitás comodidad y facilidad de movimiento. Con tu Soul XM 1000 encontrá eso que " +
                        "buscás en un solo aparato con la mejor tecnología. " +
                        "Solo debés colocar el receptor en un puerto USB de la computadora y ya podés empezar a usarlo. " +
                        "No hace falta emparejar el mouse ni descargar software para utilizarlo. " +
                        "Con batería recargable incorporada que podés cargar fácilmente con el cable USB incluido sin " +
                        "necesidad de reemplazarla. Para prolongar la duración, usá el conmutador de encendido para " +
                        "apagar el mouse cuando no lo estés usando.")
                .recommended(TRUE)
                .price(269599.00)
                .quantity(8)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        List<ProductRequestDto> list = List.of(notebook1, notebook2, notebook3, notebook4, notebook5, mouse1);

        list.forEach(productService::createProduct);
    }
}
