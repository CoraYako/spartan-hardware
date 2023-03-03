package com.spartanHardware.util;


import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.entity.ParentCategory;
import com.spartanHardware.model.entity.SubCategory;
import com.spartanHardware.repository.ParentCategoryRepository;
import com.spartanHardware.repository.SubCategoryRepository;
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
    private final ParentCategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Override
    public void run(String... args) throws Exception {
        //loadProductsData();
    }

    private void loadProductsData() {
        ProductRequestDto notebook1 = ProductRequestDto.builder()
                .name("Notebook Dell Inspiron 3515 15.5, AMD Ryzen 5, AMD Radeon RX Vega 8, Windows 11 Home")
                .brand("Dell")
                .model("Inspiron 3515")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677811733446netbook-dell%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677811781165netbook-dell%203.png"))
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
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677812002331netbook-acer%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677812183285netbook-acer%202.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677812238181netbook-acer%203.png"))
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
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677790622940netbook-msi%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677790682905netbook-msi%203.png"))
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
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677812299620netbook-asus%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677812328942netbook-asus%202.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677812350600netbook-asus%203.png"))
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
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813318453netbook-lenovo%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813348951netbook-lenovo%203.png"))
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
                .name("Mouse de juego HyperX Pulsefire Haste Negro")
                .brand("HyperX")
                .model("Pulsefire Haste")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813396259Mouse%20Gamer%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813421078Mouse%20Gamer%202.png"))
                .category("Mouse")
                .subCategory("Gamer")
                .shortDescription("Mouse de juego HyperX Pulsefire Haste color Negro")
                .description("Para trabajar desde casa con la computadora o aprovechar los momentos de ocio, necesitás comodidad y facilidad de movimiento. Con tu HyperX Pulsefire Haste encontrá eso que buscás en un solo aparato con la mejor tecnología.\n" +
                        "\n" +
                        "Adaptado a tus movimientos\n" +
                        "El mouse de juego te ofrecerá la posibilidad de marcar la diferencia y sacar ventajas en tus partidas. Su conectividad y sensor suave ayudará a que te desplaces rápido por la pantalla.\n" +
                        "\n" +
                        "La funcionalidad al alcance de tu mano\n" +
                        "El sistema de detección de movimiento óptico te permitirá mover el cursor de una manera más precisa y sensible que en los sistemas tradicionales.\n" +
                        "\n" +
                        "Plug And Play\n" +
                        "Solo debés colocar el receptor en un puerto USB de la computadora y ya podés empezar a usarlo. No hace falta emparejar el mouse ni descargar software para utilizarlo.\n" +
                        "\n" +
                        "Apto para fácil traslado\n" +
                        "Navegá rápidamente por documentos y páginas web gracias su diseño ultra delgado, ergonómico, liviano y conveniente para llevar a donde quieras o viajar.")
                .recommended(TRUE)
                .price(19990.00)
                .quantity(8)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto mouse2 = ProductRequestDto.builder()
                .name("Mouse inalámbrico Logitech M170 negro")
                .brand("Logitech")
                .model("M170")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813549888Mouse%20Logitech1.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813576559Mouse%20Logitech2.png"))
                .category("Mouse")
                .subCategory("Oficina")
                .shortDescription("Mouse inalámbrico Logitech M170 color negro")
                .description("Logitech diseña productos y experiencias que ocupan un lugar cotidiano en la vida de las personas, poniendo foco en la innovación y la calidad. Su objetivo es crear momentos verdaderamente únicos y significativos para sus usuarios. Los mouses Logitech se adaptan a la forma de tu mano para proporcionarte horas de comodidad. Sin necesidad de mover el brazo para deslizar el cursor, tu mano se fatigará menos. Son ideales para cualquier espacio de trabajo y quienes tienen la mesa llena de diversos objetos.\n" +
                        "\n" +
                        "Adaptado a tus movimientos\n" +
                        "Su diseño eficaz hace de este mouse un elemento cómodo, con una gran experiencia de uso para aquellas personas que buscan seguridad en cada click.\n" +
                        "\n" +
                        "La funcionalidad al alcance de tu mano\n" +
                        "El sistema de detección de movimiento óptico te permitirá mover el cursor de una manera más precisa y sensible que en los sistemas tradicionales.\n" +
                        "\n" +
                        "Plug And Play\n" +
                        "Solo debés colocar el receptor en un puerto USB de la computadora y ya podés empezar a usarlo. No hace falta emparejar el mouse ni descargar software para utilizarlo.\n" +
                        "\n" +
                        "Tecnología inalámbrica\n" +
                        "Trabajá de forma inalámbrica y movete libremente sin ninguna interrupción. Al no haber cables, tu escritorio se mantiene despejado. Y además, podés llevar tu mouse fácilmente de un espacio de trabajo a otro.\n" +
                        "\n" +
                        "Apto para fácil traslado\n" +
                        "Navegá rápidamente por documentos y páginas web gracias su diseño ultra delgado, ergonómico, liviano y conveniente para llevar a donde quieras o viajar.")
                .recommended(TRUE)
                .price(4199.99)
                .quantity(10)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto keyboard1 = ProductRequestDto.builder()
                .name("Teclado Mecanico Gamer Xk1000")
                .brand("Soul")
                .model("Xk1000")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813610592Teclado%20Gamer%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813636322Teclado%20Gamer%202.png"))
                .category("Teclado")
                .subCategory("Gamer")
                .shortDescription("Teclado Mecanico Gamer Xk1000 Led Switch Kailh Blue Keycap")
                .description("Este teclado Soul de alto rendimiento permite que puedas disfrutar de horas ilimitadas de juegos. Está diseñado especialmente para que puedas expresar tanto tus habilidades como tu estilo. Podrás mejorar tu experiencia de gaming, ya seas un aficionado o todo un experto y hacer que tus jugadas alcancen otro nivel.\n" +
                        "\n" +
                        "Distinción a todo color\n" +
                        "Su retroiluminación le da un toque diferente a tu equipo y resalta su composición cuando es utilizado en espacios poco iluminados.")
                .recommended(TRUE)
                .price(10704.99)
                .quantity(10)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto keyboard2 = ProductRequestDto.builder()
                .name("Teclado Tkot Tk-t100")
                .brand("Tkot")
                .model("Tk-t100")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813672462Teclado%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813692167Teclado%202.png"))
                .category("Teclado")
                .subCategory("Oficina")
                .shortDescription("Teclado Tkot Tk-t100 Multimedia")
                .description("- Marca: TKOT\n" +
                        "- Modelo: TK-T100\n" +
                        "- Formato: Multimedia\n" +
                        "- Conexin: Cable de 1.3m\n" +
                        "- Dimensiones: 435 * 128 * 20 (mm)\n" +
                        "- Teclas numricas: S\n" +
                        "- Teclas impresas con UV\n" +
                        "\n" +
                        "EAN/UPC:\n" +
                        "\n" +
                        "GARANTIA: 12")
                .recommended(FALSE)
                .price(900.99)
                .quantity(5)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto monitor1 = ProductRequestDto.builder()
                .name("Monitor gamer Samsung F27T350FHL led 27")
                .brand("Samsung")
                .model("F27T350FHL")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813746609Monitor%20gamer%20Samsung%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813768552Monitor%20gamer%20Samsung%202.png"))
                .category("Monitor")
                .subCategory("Gamer")
                .shortDescription("Monitor gamer Samsung F27T350FHL led 27 dark blue gray 100V/240V")
                .description("Samsung está fielmente comprometida en brindar productos de calidad y que contribuyan a crear un mejor futuro para las personas. Como empresa líder en la industria tecnológica uno de sus objetivos principales es desarrollar avanzadas e innovadoras soluciones. Es por ello que con este monitor tendrás y disfrutarás de una gran experiencia visual en todo momento.\n" +
                        "\n" +
                        "Un monitor a tu medida\n" +
                        "Con tu pantalla LED no solo ahorrás energía, ya que su consumo es bajo, sino que vas a ver colores nítidos y definidos en tus películas o series favoritas.\n" +
                        "\n" +
                        "Una experiencia visual de calidad\n" +
                        "Este monitor de 27\" te va a resultar cómodo para estudiar, trabajar o ver una película en tus tiempos de ocio. Asimismo, su resolución de 1920 x 1080 te permite disfrutar de momentos únicos gracias a una imagen de alta fidelidad. Una de sus virtudes es que posee pantalla antirreflejo, de esta manera no verás reflejado lo que está detrás de vos y vas a evitar forzar tu vista para enfocar el contenido. Su tiempo de respuesta de 5 ms lo hace ideal para gamers y cinéfilos porque es capaz de mostrar imágenes en movimiento sin halos o bordes borrosos.")
                .recommended(TRUE)
                .price(75599.6)
                .quantity(9)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto monitor2 = ProductRequestDto.builder()
                .name("Monitor Asus 24 Ips Fhd 75hz Hdmi Vga Va24ehe")
                .brand("Asus")
                .model("Va24ehe")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813792503Monitor%20Asus%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813811289Monitor%20Asus%202.png"))
                .category("Monitor")
                .subCategory("Oficina")
                .shortDescription("Monitor ASUS VA24EHE Eye Care: 23.8 pulgadas- Full HD- IPS- sin marco- 75Hz- Adaptive-Sync / FreeSync™- Low Blue Light- Flicker Free- montable en la pared")
                .description("Pantalla de retroiluminación LED Full HD (1920x1080) de 23.8 pulgadas con panel de ángulo de visión IPS de 178 ° de ancho.\n" +
                        "Frecuencia de actualización de hasta 75Hz con la tecnología Adaptive-Sync / FreeSync ™ para eliminar el rastreo y garantizar una reproducción de video nítida y clara.\n" +
                        "Amplia conectividad que incluye puertos HDMI y D-sub.\n" +
                        "Montaje en pared VESA para ahorrar espacio en el escritorio.\n" +
                        "Los monitores ASUS Eye Care cuentan con tecnologías Flicker-free y Low Blue Light certificadas por TÜV Rheinland para garantizar una experiencia de visualización cómoda.\n" +
                        "Admite tanto Adaptive-Sync con tarjetas gráficas NVIDIA GeForce* como FreeSync con tarjetas gráficas AMD Radeon* Compatible con NVIDIA GeForce GTX 10 seri")
                .recommended(TRUE)
                .price(69691.55)
                .quantity(9)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto microprocessorIntel = ProductRequestDto.builder()
                .name("Procesador Core I7 12700 12 Cores 20 Hilos 4.9ghz Lga1700")
                .brand("Intel")
                .model("Core I7 12700")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813854773Intel%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813883957Intel%202.png"))
                .category("Microprocesadores")
                .subCategory("Intel")
                .shortDescription("Microprocesador Core I7 12700 12 Cores 20 Hilos 4.9ghz Lga1700")
                .description("Especificaciones de la CPU\n" +
                        "Cantidad de núcleos 12\n" +
                        "Cantidad de Performance-cores8\n" +
                        "Cantidad de Efficient-cores4\n" +
                        "Cantidad de subprocesos 20\n" +
                        "Frecuencia turbo máxima 4.90 GHz\n" +
                        "Frecuencia de la Tecnología Intel® Turbo Boost Max 3.0 ‡ 4.90 GHz\n" +
                        "Frecuencia turbo máxima del Performance-core 4.80 GHz\n" +
                        "Frecuencia turbo máxima de Efficient-core 3.60 GHz\n" +
                        "Frecuencia base de Performance-core2.10 GHz\n" +
                        "Frecuencia base de Efficient-core1.60 GHz\n" +
                        "Caché 25 MB Intel® Smart Cache\n" +
                        "Caché L2 total12 MB\n" +
                        "Potencia base del procesador 65 W\n" +
                        "Potencia turbo máxima 180 W\n" +
                        "\n" +
                        "Especificaciones de memoria\n" +
                        "Tamaño de memoria máximo (depende del tipo de memoria) 128 GB\n" +
                        "Tipos de memoria Up to DDR5 4800 MT/s\n" +
                        "Up to DDR4 3200 MT/s\n" +
                        "Cantidad máxima de canales de memoria 2\n" +
                        "Máximo de ancho de banda de memoria 76.8 GB/s\n" +
                        "\n" +
                        "Opciones de expansión\n" +
                        "Revisión de la interfaz de medios directa (DMI)4.0\n" +
                        "Cantidad máxima de carriles DMI8\n" +
                        "Escalabilidad1S Only\n" +
                        "Revisión de PCI Express 5.0 and 4.0\n" +
                        "Configuraciones de PCI Express ‡ Up to 1x16+4- 2x8+4\n" +
                        "Cantidad máxima de líneas PCI Express 20\n" +
                        "\n" +
                        "Especificaciones de paquete\n" +
                        "Zócalos compatibles FCLGA1700\n" +
                        "Máxima configuración de CPU1\n" +
                        "Especificación de solución térmica PCG 2020C\n" +
                        "TJUNCTION 100°C\n" +
                        "Tamaño de paquete45.0 mm x 37.5 mm\n" +
                        "\n" +
                        "Tecnologías avanzadas\n" +
                        "Acelerador Intel® gausiano y neural 3.0\n" +
                        "Intel® Thread DirectorSí\n" +
                        "Intel® Deep Learning Boost (Intel® DL Boost) Sí\n" +
                        "Compatible con la memoria Intel® Optane™ ‡ Sí\n" +
                        "Tecnología Intel® Speed Shift Sí\n" +
                        "Tecnología Intel® Turbo Boost Max 3.0 ‡ Sí\n" +
                        "Tecnología Intel® Turbo Boost ‡ 2.0\n" +
                        "Tecnología Intel® Hyper-Threading ‡ Sí\n" +
                        "Intel® 64 ‡ Sí\n" +
                        "Conjunto de instrucciones 64-bit\n" +
                        "Extensiones de conjunto de instrucciones Intel® SSE4.1- Intel® SSE4.2- Intel® AVX2\n" +
                        "Estados de inactividad Sí\n" +
                        "Tecnología Intel SpeedStep® mejorada Sí\n" +
                        "Tecnologías de monitoreo térmico Sí\n" +
                        "Dispositivo de gestión de volúmenes (VMD) Intel® Sí")
                .recommended(TRUE)
                .price(147767.6)
                .quantity(9)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto microprocessorAMD = ProductRequestDto.builder()
                .name("Procesador Amd Ryzen 5 5600g Sixcore 4.4ghz Turbo")
                .brand("AMD")
                .model("Ryzen 5 5600g")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813931886Ryzen%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677813959577Ryzen%202.png"))
                .category("Microprocesadores")
                .subCategory("AMD")
                .shortDescription("Procesador Amd Ryzen 5 5600g Sixcore 4.4ghz Turbo")
                .description("Cuando cuentas con la arquitectura de procesadores más avanzada del mundo para jugadores y creadores de contenido- las posibilidades son infinitas.\n" +
                        "Ya sea que juegues los juegos más recientes- diseñes el próximo rascacielos o proceses datos- necesitas un procesador poderoso que pueda dar respuesta a todas estas demandas- y más.\n" +
                        "\n" +
                        "Marca : AMD\n" +
                        "Línea : Ryzen\n" +
                        "Modelo : 5600G\n" +
                        "Modelo alfanumérico : 100-100000252BOX\n" +
                        "UPC : 730143313414\n" +
                        "GPU integrado : Radeon Graphics\n" +
                        "Caché : 16 MB Cantidad de núcleos de CPU : 6\n" +
                        "Hilos : 12\n" +
                        "Tipos de memoria RAM soportadas : DDR4\n" +
                        "Socket : AM4\n" +
                        "Frecuencia mínima de reloj : 3-9 GHz\n" +
                        "Frecuencia máxima de reloj : 4-4 GHz\n" +
                        "Desbloqueado para OC : Si\n" +
                        "TDP : 65W")
                .recommended(TRUE)
                .price(84049.90)
                .quantity(9)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto motherboardAMD = ProductRequestDto.builder()
                .name("Motherboard Gigabyte A520m H")
                .brand("Gigabyte")
                .model("A520m H")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814009357Board%20Gigabyte%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814028726Board%20Gigabyte%202.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814051552Board%20Gigabyte%203.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814070490Board%20Gigabyte%204.png"))
                .category("Motherboard")
                .subCategory("AMD")
                .shortDescription("Placa Madre Gigabyte A520m H")
                .description("Aplicaciones: AMD\n" +
                        "Marca: Gigabyte\n" +
                        "Chipset: a520\n" +
                        "Plataforma: AMD\n" +
                        "Ranuras de expansión: 4\n" +
                        "Condición del ítem: Nuevo\n" +
                        "Línea: A520\n" +
                        "Capacidad máxima soportada de la memoria RAM: 32 GB\n" +
                        "Modelo: A520M H\n" +
                        "Socket: AM4\n" +
                        "Tipo de memoria RAM: DDR4\n" +
                        "Versión: rev. 1.0\n" +
                        "Con procesador: No")
                .recommended(TRUE)
                .price(26078.65)
                .quantity(5)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto motherboardAsus = ProductRequestDto.builder()
                .name("Motherboard Asus Prime H610m-k D4 Socket 1700")
                .brand("Asus")
                .model("Prime H610m-k")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814108557Board_Asus_1.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814191481Board_Asus_2.png"))
                .category("Motherboard")
                .subCategory("Intel")
                .shortDescription("Placa Madre Asus Prime H610m-k D4 Socket 1700")
                .description("CPU\n" +
                        "Zócalo Intel LGA1700 para 12®ésimo Procesadores Intel Core™- Pentium Gold y Celeron de la generación\n" +
                        "Compatible con la tecnología Intel Turbo Boost 2.0 y la tecnología Intel Turbo Boost Max 3.0\n" +
                        "\n" +
                        "\n" +
                        "Chipset\n" +
                        "Intel H610 Chipset®\n" +
                        "\n" +
                        "Memoria\n" +
                        "2 x DIMM- máx. 64 GB- DDR4 3200/3000/2933/2800/2666/2400/2133 sin ECC- memoria sin búfer*\n" +
                        "Arquitectura de memoria de doble canal\n" +
                        "\n" +
                        "Gráficos\n" +
                        "1 x puerto D-Sub\n" +
                        "1 x puerto HDMI\n" +
                        "\n" +
                        "Ranuras de expansión\n" +
                        "Intel 12®ésimo Procesadores gen\n" +
                        "1 x ranura PCIe 4.0 x16\n" +
                        "Intel H610 Chipset®\n" +
                        "1 x ranura PCIe 3.0 x1\n" +
                        "\n" +
                        "Almacenamiento\n" +
                        "Total admite 1 x ranura M.2 y 4 x puertos SATA de 6 Gb/s\n" +
                        "Intel H610 Chipset®\n" +
                        "Ranura M.2 (clave M)- tipo 2242/2260/2280 (admite modos PCIe 3.0 x4 y SATA)\n" +
                        "4 x puertos SATA 6Gb/s\n" +
                        "\n" +
                        "Ethernet\n" +
                        "1 x Realtek 1Gb Ethernet\n" +
                        "\n" +
                        "USB\n" +
                        "USB trasero (total de 6 puertos)\n" +
                        "2 x puertos USB 3.2 Gen 1 (2 x Tipo-A)\n" +
                        "4 x puertos USB 2.0 (4 x Tipo-A)\n" +
                        "USB frontal (total de 4 puertos)\n" +
                        "1 x cabezal USB 3.2 Gen 1 admite 2 puertos USB 3.2 Gen 1 adicionales\n" +
                        "1 x cabezal USB 2.0 admite 2 puertos USB 2.0 adicionales\n" +
                        "\n" +
                        "Audio\n" +
                        "Realtek 7.1 Sonido envolvente de alta definición Audio CODEC\n" +
                        "\n" +
                        "Puertos de E/S del panel posterior\n" +
                        "2 x puertos USB 3.2 Gen 1 (2 x Tipo-A)\n" +
                        "4 x puertos USB 2.0 (4 x Tipo-A)\n" +
                        "1 x puerto D-Sub\n" +
                        "1 x puerto HDMI®\n" +
                        "1 x puerto Ethernet Realtek de 1 Gb\n" +
                        "3 x conectores de audio\n" +
                        "1 x puerto combinado de teclado/ratón PS/2\n" +
                        "\n" +
                        "Conectores de E/S internos\n" +
                        "Ventilador y refrigeración relacionados\n" +
                        "1 x cabezal de ventilador de CPU de 4 pines\n" +
                        "1 x cabezal de ventilador de chasis de 4 pines\n" +
                        "1 x conector de alimentación principal de 24 pines\n" +
                        "1 x conector de alimentación de 8 pines + 12V\n" +
                        "1 x ranura M.2 (Llave M)\n" +
                        "4 x puertos SATA 6Gb/s\n" +
                        "USB\n" +
                        "1 x cabezal USB 3.2 Gen 1 admite 2 puertos USB 3.2 Gen 1 adicionales\n" +
                        "1 x cabezal USB 2.0 admite 2 puertos USB 2.0 adicionales\n" +
                        "Misceláneo\n" +
                        "1 x encabezado RGB\n" +
                        "1 x Borrar encabezado CMOS\n" +
                        "1 x encabezado de puerto COM\n" +
                        "1 x cabezal de audio del panel frontal (AAFP)\n" +
                        "1 x encabezado de salida S / PDIF\n" +
                        "1 x encabezado del altavoz\n" +
                        "1 x cabezal SPI TPM (14-1pin)\n" +
                        "1 x cabezal del panel del sistema de 10-1 pines\n" +
                        "\n" +
                        "Factor de forma\n" +
                        "mATX 9.2 inch x 8.0 inch ( 23.4 cm x 20.3 cm )")
                .recommended(TRUE)
                .price(35269.99)
                .quantity(3)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto tower1 = ProductRequestDto.builder()
                .name("Gabinete Aureox Orion Arx 350g C/vent")
                .brand("Aureox")
                .model("Orion Arx 350g")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677790441182Gabinete%20Gamer%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814262628Gabinete%20Gamer%202.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814288391Gabinete%20Gamer%203.png"))
                .category("Gabinete")
                .subCategory("Gamer")
                .shortDescription("Gabinete Aureox Orion Arx 350g C/vent Gamer ")
                .description("-RGB LED STRIP FRONTAL\n" +
                        "-COLORES RGB CON SELECCIÓN POR MOTHER O BOTÓN DEDICADO\n" +
                        "-MULTIRING RGB FAN TRASERO DE 120mm\n" +
                        "-FILTRO SUPERIOR ANTIPOLVO REMOVIBLE MAGNÉTICAMENTE\n" +
                        "-LATERAL ÍNTEGRAMENTE DE VIDRIO TEMPLADO\n" +
                        "-CHASIS GAMER DISEÑADO CON CABLE MANAGEMENT\n" +
                        "-COMPARTIMIENTO INFERIOR PARA PSU- AISLADO DEL HARD\n" +
                        "-PANEL LATERAL: VIDRIO TEMPLADO\n" +
                        "-PANEL FRONTAL:1x USB3.0 + 2x USB2.0 + HD AUDIO\n" +
                        "-BAHÍAS: 2x 3.5\"+ 2x 2.5\"\n" +
                        "-CAPACIDAD DE VENTILADORES: 6\n" +
                        "-APTO PARA WATERCOOLING\n" +
                        "-DIMENSIONES: 34.2x18.5x41.3cm")
                .recommended(TRUE)
                .price(19221.60)
                .quantity(3)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto tower2 = ProductRequestDto.builder()
                .name("Gabinete Solarmax Cm-5908")
                .brand("Solarmax")
                .model("Cm-5908")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814333620Gabinete%20Oficina%201.png"))
                .category("Gabinete")
                .subCategory("Oficina")
                .shortDescription("Gabinete Solarmax Cm-5908")
                .description("Modelo: CM-5908\n" +
                        "Tipo de estructura: Mini Tower\n" +
                        "Tipos de puertos: USB 2.0\n" +
                        "Tipos de bahías: 2 X5.25\n" +
                        "Potencia de la fuente de alimentación: 500 W\n" +
                        "Altura: 365 m\n" +
                        "Ancho: 325 m\n" +
                        "Largo :175 cm")
                .recommended(FALSE)
                .price(18630.96)
                .quantity(1)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto cooler1 = ProductRequestDto.builder()
                .name("Fan Aerocool Astro 12f Argb 120mm")
                .brand("Astro")
                .model("12f")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814362397Cooler%20RGB%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814411388Cooler%20RGB%202.png"))
                .category("cooler")
                .subCategory("gamer")
                .shortDescription("Astro 12F PWM VENTILADOR DE PC ARGB 12CM Ventilador de 120 mm")
                .description("Posee un conector PWM de 4 pines que presenta un diseño LED Omni RGB único y elegante con iluminación Core RGB en el centro del ventilador para brindar una experiencia de iluminación completa y vibrante. Acceda a 16-8 millones de colores utilizando placas base RGB direccionables compatibles- incluidas ASUS Aura Sync- MSI Mystic Light Sync y Gigabyte RGB Fusion. Requiere placa base RGB direccionable o concentradores (H66F / H106C).\n" +
                        "\n" +
                        "Especificaciones:\n" +
                        "Marca: Aerocool\n" +
                        "Modelo: Astro 12F PWM\n" +
                        "Codigo del fabricante: ASTRO 12F\n" +
                        "Codigo universal del producto: 4710562754070\n" +
                        "Dimensiones del ventilador (L x W x H): 120 x 120 x 25 mm\n" +
                        "Velocidad del ventilador: 600-1800 rpm\n" +
                        "Voltaje de arranque del ventilador: 7V\n" +
                        "Voltaje nominal: 12 V\n" +
                        "Corriente nominal: 1.3A\n" +
                        "El consumo de energía: 15-6 W\n" +
                        "tipo de conector Ventilador: Molex\n" +
                        "ARGB: 3 pines\n" +
                        "Presión del aire: 2-07 mmH2O\n" +
                        "Flujo de aire: 68.4CFM\n" +
                        "Nivel de ruido del ventilador: 14-2-21-8 dBA\n" +
                        "Tipo de rodamiento: Cojinete Hidráulico\n" +
                        "MTBF (tiempo medio antes de la falla): 60000 horas")
                .recommended(TRUE)
                .price(7458.55)
                .quantity(19)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto cooler2 = ProductRequestDto.builder()
                .name("Fan Coolermaster Masterfan Mf120 S3 120mm Dual Ring")
                .brand("Masterfan")
                .model("Mf120 S3")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814460338Cooler%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814479121Cooler%202.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814496264Cooler%203.png"))
                .category("cooler")
                .subCategory("oficina")
                .shortDescription("Fan Coolermaster Masterfan Mf120 S3 120mm Dual Ring")
                .description("- 1800 RPM- 52 CFM\n" +
                        "- Rifle Bearing\n" +
                        "- Air Balance Fan Design\n" +
                        "- Almohadillas antivibración\n" +
                        "RM 49")
                .recommended(TRUE)
                .price(5786.00)
                .quantity(9)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto ram1 = ProductRequestDto.builder()
                .name("Memoria Ram Xpg Spectrix D60 8gb Ddr4 3200")
                .brand("XPG")
                .model("AX4U320038G16A-ST60")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814603619Ram%20RGB%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814641149Ram%20RGB%202.png"))
                .category("Memoria Ram")
                .subCategory("Gamer")
                .shortDescription("Memoria Ram Xpg Spectrix D60 8gb Ddr4 3200")
                .description("Si notás que tu computadora tiene bajo rendimiento o que su capacidad no se adapta a tus necesidades de uso- es momento de renovar su memoria RAM. Aumentarás su productividad y podrás trabajar de manera rápida y en simultáneo con múltiples aplicaciones.\n" +
                        "\n" +
                        "Marca: XPG\n" +
                        "Línea: Spectrix D60G\n" +
                        "Modelo: AX4U320038G16A-ST60\n" +
                        "Capacidad total: 8 GB\n" +
                        "Módulos de memoria: 1 x 8 GB\n" +
                        "Tecnología: DDR4\n" +
                        "Formato: UDIMM\n" +
                        "Velocidad: 3200 MHz\n" +
                        "Es gamer: Sí\n" +
                        "Color: Tungsten grey\n" +
                        "Cantidad de pines: 288\n" +
                        "Tasa de transferencia: 25600 MB/s\n" +
                        "Latencia CAS: 16\n" +
                        "Voltaje de alimentación: 1.35V\n" +
                        "Aplicación: Computadoras de escritorio\n" +
                        "Compatibilidades de la memoria: AMD- Intel")
                .recommended(TRUE)
                .price(22032.33)
                .quantity(9)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto ram2 = ProductRequestDto.builder()
                .name("Memoria Ram Adata 8gb Ddr4 2666mhz Udimm")
                .brand("Adata")
                .model("PC4-21300")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814692804Ram%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814726450Ram%202.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814847945Ram%203.png"))
                .category("Memoria Ram")
                .subCategory("Oficina")
                .shortDescription("Memoria Ram Adata 8gb Ddr4 2666mhz Udimm")
                .description("Todos los módulos de memoria ADATA han sido producidos y probados usando rigurosos procesos de control de calidad para un procesamiento rápido y una operación estable. Además- los módulos de memoria ADATA ofrecen a los clientes una garantía de por vida para asegurar al máximo un servicio excelente.\n" +
                        "\n" +
                        "\n" +
                        "ESPECIFICACIONES TÉCNICAS:\n" +
                        "\n" +
                        "Tipo de módulo U-DIMM\n" +
                        "Factor de forma altura estándar de 1-23\"\n" +
                        "Tipo de memoria DDR4\n" +
                        "Estándar JEDEC\n" +
                        "Interfaz 288 contactos\n" +
                        "Densidad 8GB\n" +
                        "Velocidad 2666MHz\n" +
                        "Latencia CAS CL 19-19-19\n" +
                        "Fuente de alimentación VDD y VDDQ = 1-2V±0-06V\n" +
                        "Fuente de alimentación de activación DRAM VPP= 2.5V (+0-25V / -0-125V)\n" +
                        "Especificaciones/VCC DRAM DDR4 STD 1-2V\n" +
                        "Temperaturas de operación 0°C a 85°C")
                .recommended(TRUE)
                .price(15005.09)
                .quantity(15)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();


        ProductRequestDto videoCard1 = ProductRequestDto.builder()
                .name("Placa De Video Gigabyte Rtx 3080 Gaming Oc 10gb Gddr6x 320bit Caja Negra Oem")
                .brand("Gigabyte")
                .model("Rtx 3080 Gaming")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814913380Video%20Card%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814931297Video%20Card%202.png"))
                .category("Tarjeta de Video")
                .subCategory("Gamer")
                .shortDescription("Placa De Video Gigabyte Rtx 3080 Gaming Oc 10gb Gddr6x 320bit Caja Negra Oem")
                .description("GeForce RTX 3080\n" +
                        "La Jugada Definitiva\n" +
                        "Las tarjetas gráficas GeForce RTX™ 3080 ofrecen el alto rendimiento que buscan los gamers. Basado en Ampere- la segunda generación de la arquitectura RTX de NVIDIA- cuentan con Núcleos RT mejorados y Núcleos Tensor- nuevos multiprocesadores de transmisión y memorias GDDR6X súper rápidas- para una experiencia de juego simplemente increíble.\n" +
                        "\n" +
                        "Chipset: GeForce GeForce® RTX 3080\n" +
                        "Core Clock: 1800 MHz\n" +
                        "CUDA Cores: 8704\n" +
                        "Tamaño y tipo de memoria: 10Gb GDDR6\n" +
                        "Interfaz de memoria: 320 bit\n" +
                        "Velocidad de memoria: 760 GB/s\n" +
                        "Microsoft DirectX: 12\n" +
                        "OpenGL: 4\n" +
                        "Interfaz: 3x Display Port- 2x HDMI\n" +
                        "Tamaño de la placa: 320 W=129 H=55 mm\n" +
                        "Conectores de fuente: 8-pin x2\n" +
                        "Fuente recomendada: 750w")
                .recommended(TRUE)
                .price(274093.6)
                .quantity(4)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto videoCard2 = ProductRequestDto.builder()
                .name("Placa De Video MSI Asrock Rx 550 Phantom 2gb")
                .brand("MSI")
                .model("Asrock Rx 550")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677814965478Video%20Card%20MSI%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677815017548Video%20Card%20MSI%202.png"))
                .category("Tarjeta de Video")
                .subCategory("Gamer")
                .shortDescription("Placa De Video MSI Asrock Rx 550 Phantom 2gb")
                .description("El software MSI Adrenalin 2019 Edition le brinda más control sobre sus experiencias de juego. La interfaz intuitiva del software permite a los jugadores transmitir- compartir y modificar configuraciones de gráficos en tiempo real sin perder un segundo de la acción o comprometer el rendimiento en el juego.\n" +
                        "Aproveche sus victorias de juego con las funciones de transmisión fácil de MSI ReLive\n" +
                        "Trabaje de manera más inteligente y fresca con Radeon™ Chill: le ayuda de forma dinámica a ahorrar energía mientras juega\n" +
                        "Personaliza tu juego con perfiles personalizados y mejora el rendimiento de tu PC con MSI WattMan*\n" +
                        "Adapte las preferencias sin tener que abandonar su juego con MSI Overlay.\n" +
                        "\n" +
                        "- TWEAK DE JUEGO FANTASMA:\n" +
                        "Una herramienta rápida y sencilla que proporciona a los usuarios una abundante colección de configuraciones sutiles para ajustar profesionalmente- como la velocidad del ventilador- los core clocks- la frecuencia de la memoria- etc. Los usuarios también pueden elegir el modo más optimizado según sus necesidades- como el modo OC- el modo silencioso o el modo predeterminado. Phantom Gaming Tweak ofrece opciones de configuración de voltaje más que suficientes para cualquiera que desee alcanzar los extremos.\n" +
                        "\n" +
                        "- SINCRONIZACIÓN MEJORADA:\n" +
                        "Enhanced sync permite un juego de baja latencia en prácticamente cualquier framerate y una experiencia sin rasgaduras cuando el framerate de tu juego favorito excede la velocidad de actualización de tu pantalla.\n" +
                        "Desbloquee su VSync. La tecnología Enhanced sync ofrece una experiencia sin fisuras cuando la velocidad de fotogramas supera la frecuencia de actualización de la pantalla en una latencia ultra baja para llevar su juego E-Sports al próximo nivel.\n" +
                        "\n" +
                        "Especificaciones técnicas:\n" +
                        "\n" +
                        "- Procesador Gráfico - MSI RX 550\n" +
                        "- Bus Standard - PCI Express x16 Gen3 (usa x8)\n" +
                        "- DirectX - 12\n" +
                        "- OpenGL - OpenGL 4.5\n" +
                        "- Memória - GDDR5 2GB\n" +
                        "- Clock do procesador - Up to 1183MHz\n" +
                        "- Intel® XMX Engines - 512\n" +
                        "- Clock de memoria - 6000 MHz\n" +
                        "- Memory Interface - 128-bit\n" +
                        "- Resolución - Resolución máxima digital: 5120 x 2880 @ 60Hz\n" +
                        "\n" +
                        "- Interface - 1 x Dual-link DVI-D; 1 x HDMI 2.0; 1 x DisplayPort 1.4\n" +
                        "- HDCP - Yes\n" +
                        "- Multi-view - 3\n" +
                        "- PSU recomendada - 350W\n" +
                        "- Accesorios - 1 x CD de Soporte; 1 x Guía de instalación rápida\n" +
                        "- Dimensiones - 169.58 x 130.89 x 42.05mm")
                .recommended(TRUE)
                .price(35404.00)
                .quantity(1)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto disco1 = ProductRequestDto.builder()
                .name("Disco Rigido Western Digital Blue 1tb Sata 6gb/s 64mb Buffer")
                .brand("Western")
                .model("Digital Blue")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677815061378disco-duro%201.png",
                        "https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677815091229disco-duro%202.png"))
                .category("Disco")
                .subCategory("Rigido")
                .shortDescription("Disco Rigido Western Digital Blue 1tb Sata 6gb/s 64mb Buffer")
                .description("Western Digital- una de las marcas con más renombre en el mundo en almacenamiento de datos- con la cual te permite crear- experimentar y guardar contenidos- gracias a su amplia gama de dispositivos. La alta seguridad y rendimiento que brindan sus unidades la convierten en una de las empresas más elegidas del mercado.\n" +
                        "El WD Blue WD10EZEX se caracteriza por su eficiencia y buen funcionamiento- que sumado a su reducido consumo energético lo vuelven un disco indispensable para funciones estándar.\n" +
                        "\n" +
                        "Modelo: WD10EZEX\n" +
                        "Interfaz: SATA III (6 GB/s)\n" +
                        "Tamaño del búfer: 64 MB\n" +
                        "Velocidad de rotación: 7200 RPM\n" +
                        "Capacidad: 1 TB\n" +
                        "Tiempos de acceso: 0-6 ms (lectura) / 0-8 ms (escritura)\n" +
                        "Carga / descarga: 300.000 veces\n" +
                        "Consumo de energía: 6-4W (lectura/escritura); 3-7W (detenido); 1W (stand-by/sleep)\n" +
                        "Dimensiones (al. x prof. x an.): 2-61 x 14-7 x 10-16 cm\n" +
                        "Peso: 450 g\n" +
                        "Temperatura operativa: 0°C a 60°C\n" +
                        "Temperatura no operativa: -40°C a 70°C")
                .recommended(TRUE)
                .price(14283.00)
                .quantity(10)
                .available(TRUE)
                .fastShipping(FALSE)
                .build();

        ProductRequestDto disco2 = ProductRequestDto.builder()
                .name("Disco Ssd Adata Su630 Ultimate 240gb 2.5")
                .brand("Adata")
                .model("Su630 Ultimate")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677815109320Disco%20ssd.png"))
                .category("Disco")
                .subCategory("SSD")
                .shortDescription("Disco Ssd Adata Su630 Ultimate 240gb 2.5")
                .description("Adata- empresa taiwanesa de renombre internacional se encarga de producir dispositivos de almacenamiento con un alto estándar de calidad. Estos te permiten resguardar tus archivos de manera segura.\n" +
                        "El Ultimate SU630 ASU630SS-240GQ-R está adaptado para que puedas acceder de forma rápida a tus documentos digitales gracias a su tecnología en estado sólido.\n" +
                        "\n" +
                        "Irrompible\n" +
                        "Además de su funcionalidad y soporte- la importancia de los discos de almacenamiento también radica en su calidad y resistencia. Despreocupate y disfrutá de la durabilidad de este producto debido a su capacidad de absorber y resistir fuertes impactos.\n" +
                        "\n" +
                        "Más velocidad a tu alcance\n" +
                        "Este producto posee una interfaz SATA III que se encarga de transferir datos con la placa madre de tu computadora. Es de gran importancia y con su velocidad de envío de información mejora el rendimiento. Vas a poder cargar todo tipo de archivos en tu PC con rapidez.")
                .recommended(FALSE)
                .price(9580.50)
                .quantity(1)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto disco3 = ProductRequestDto.builder()
                .name("Disco Ssd M.2 Wd Black Sn770 512 gb Nvme 5150 Mb/s")
                .brand("Western Digital")
                .model("Wd Black Sn770")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677815125613Disco%20SSD%20M2.png"))
                .category("Disco")
                .subCategory("M2")
                .shortDescription("Disco Ssd M.2 Wd Black Sn770 2tb Nvme 5150 Mb/s")
                .description("Abróchese el cinturón para conseguir velocidades de juego extremadamente altas con la unidad SSD WD_BLACK SN850X NVMe™. Disminuya los tiempos de carga y reduzca la ralentización- el retraso y los poppings del modelo para lograr una experiencia fluida y rápida que le permita competir al máximo nivel. Esta unidad diseñada especialmente para juegos cuenta con capacidades desde 1 TB hasta 4 TB1- con un disipador térmico opcional en las unidades de 1 TB y 2 TB- el cual permite mantener el rendimiento de primer nivel para que el juego sea más uniforme. Gracias a las características avanzadas del modo de juego 2.0 (solo para Windows®) y las velocidades que se aproximan a los límites de la interfaz PCIe® Gen 43- la unidad SSD WD_BLACK SN850X NVMe brinda un rendimiento de primer nivel para que siga jugando- transmitiendo- grabando y dominando el juego.\n" +
                        "\n" +
                        "\n" +
                        "Descripción\n" +
                        "-Factor de forma: M.2 2280\n" +
                        "-Interfaz: PCIe Gen4 x4\n" +
                        "-Rendimiento de lectura secuencial: 5150MB/s\n" +
                        "-Rendimiento de escritura secuencial: 4850MB/s\n" +
                        "-Random Read: 7400004KB IOPS\n" +
                        "-Random Write: 8000004KB IOPS\n" +
                        "-Compatibilidad:\n" +
                        "Computadora con puerto M.2 (de tipo M)- capaz de tomar un factor de forma M.2 2280\n" +
                        "Windows® 11- Windows® 10 y Windows® 8.1\n" +
                        "Nota: La compatibilidad puede variar según la configuración del hardware y del sistema operativo del usuario.\n" +
                        "-Dimensiones (largo- ancho y alto)\n" +
                        "3.15\" x 0.87\" x 0.09\"")
                .recommended(TRUE)
                .price(58430.00)
                .quantity(1)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        ProductRequestDto source = ProductRequestDto.builder()
                .name("Fuente Aureox Unlimited Series 550w 80 Plus Bronze")
                .brand("Aureox")
                .model("Unlimited Series")
                .images(List.of("https://ecommerce.spartan.images.s3.us-east-2.amazonaws.com/1677815159805Fuente.png"))
                .category("Fuente")
                .subCategory("Bronze")
                .shortDescription("Fuente Aureox Unlimited Series 550w 80 Plus Bronze")
                .description("Con la fuente de alimentación Aureox ARXGU-80PBZ-550W podrás asegurar la corriente continua y estable de tu computadora de escritorio y optimizar el funcionamiento de sus componentes.\n" +
                        "A través de su sistema de refrigeración- podrás mantener la temperatura ideal de sus componentes y evitar el sobrecalentamiento.\n" +
                        "\n" +
                        "CERTIFICACION 80 PLUS BRONZE\n" +
                        "550W REALES DE POTENCIA\n" +
                        "PFC ACTIVO\n" +
                        "VENTILADOR DE 120mm CON ASPAS COLOR BLANCO\n" +
                        "CONTROL DE TEMPERATURA Y VELOCIDAD\n" +
                        "RECUBRIMIENTO NEGRO\n" +
                        "CABLES MAYADOS\n" +
                        "2 x IDE (Molex)\n" +
                        "4 x SATA\n" +
                        "1 x 20+4P\n" +
                        "1 x 4+4P\n" +
                        "1 x 6+2P")
                .recommended(TRUE)
                .price(17179.00)
                .quantity(13)
                .available(TRUE)
                .fastShipping(TRUE)
                .build();

        List<ProductRequestDto> list = List.of(notebook1, notebook2, notebook3, notebook4, notebook5, mouse1, mouse2, keyboard1, keyboard2, monitor1, monitor2, microprocessorIntel, microprocessorAMD, motherboardAMD, motherboardAsus, tower1, tower2, cooler1, cooler2, ram1, ram2, videoCard1, videoCard2, disco1, disco2, disco3, source);

        list.forEach(productService::createProduct);
    }
}
