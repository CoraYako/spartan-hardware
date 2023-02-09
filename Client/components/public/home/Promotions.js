import styled from 'styled-components'
import { motion } from 'framer-motion'
import { Anchor } from '../../common/Anchor'
import { PromotionCard } from '@/components/common/PromotionCard'
import ImageNotebook from '@/public/images/test_img_notebook.png'
import ImageShipping from '@/public/images/test_img_shipping.png'

export const Promotions = ({ props }) => {
  return (
    <Main>
      <div className="title">
        <h2>Promociones y servicios</h2>
      </div>
      <div className="promotions">
        <div className="services">
          <p>
            Encuentra aqui todas las promociones que la plataforma tiene
            disponibles para nuestros clientes, estas promociones van desde los
            productos mas vendidos, los productos con un mayor descuento. Accede
            a ellos de una forma rapida.
          </p>
          <p className="second">
            Tambien puede encontrar nuestro servicio de envios de mercancia a
            cualquier punto del pais sin costo adicional.
          </p>
        </div>
        <PromotionCard typeLabel="promotion" />
        <PromotionCard
          img={ImageNotebook}
          title="MateBook X Pro"
          typeLabel="promotion"
          details={{
            first: 'Profundidad: 271mm',
            second: 'Altura: 146.6 mm',
            three: 'Peso: Aprox 1.33 kg',
          }}
        />
        <PromotionCard
          img={ImageShipping}
          title="Servicio de envios 24 horas"
          typeLabel="shipping"
          msgLabel="Servicio de envios"
          details={{
            first: 'Consulta terminos y condiciones',
            second: 'Para recibir tu producto con nuestro',
            three: 'servicio de envios',
          }}
        />
      </div>
    </Main>
  )
}

const Main = styled(motion.section)`
  max-width: 1300px;
  display: flex;
  flex-direction: column;
  margin: 7rem auto 0;
  padding: 0 2.5rem;
  .title {
    display: flex;
    gap: 13px;
    color: #454545;
  }

  .promotions {
    display: flex;
    flex-direction: row;
    gap: 25px;
    padding: 3.5rem 0;
    flex-wrap: wrap;
  }

  .services {
    max-width: 282px;
    color: #000;
    p {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 400;
      font-size: 14px;
      line-height: 21px;
    }
  }
  .second {
    margin-top: 1rem;
  }
`
