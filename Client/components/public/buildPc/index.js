import styled from 'styled-components'
import { CardTradeMark } from './CardTradeMark'
import LogoAMD from '@/public/images/AMD.png'
import LogoIntel from '@/public/images/Intel-Logo.png'
import { CardCategory } from './CardCategory'
import { steps } from './helper'
import { Steps } from './Steps'
import { Button } from '@/components/common/Button'

export const BuildPcComponent = ({ router, data, setcategory }) => {
  return (
    <Container>
      <h2 className="title">Arma tu Pc</h2>
      {!router && (
        <p className="sub-title">
          Llegaste a Armar Tu Pc aquí podras armar tu nueva computadora con los
          componentes que quieras para que logres el rendimiento deseado. Lo
          primero que vas hacer es seleccionar el procesador de tu gusto y
          despues cada componente, vamos a empezar.
        </p>
      )}
      {router && (
        <div className="container_button">
          <p>Crees que terminaste?</p>
          <Button text="FINALIZAR COMPRA" to="/cart" />
        </div>
      )}
      <div className="content">
        {!router ? (
          <>
            <div className="options">
              {steps &&
                steps.map((item) => (
                  <CardCategory
                    key={item?.index}
                    disabled
                    category={item?.name}
                    icon={item?.Icon}
                  />
                ))}
            </div>
            <div className="right">
              <CardTradeMark
                image={LogoIntel}
                title="Microprocesadores INTEL"
                href="/build-pc/Intel"
              />
              <CardTradeMark
                image={LogoAMD}
                title="Microprocesadores AMD"
                href="/build-pc/AMD"
              />
            </div>
          </>
        ) : (
          <Steps dataProducts={data} setcategory={setcategory} />
        )}
      </div>
    </Container>
  )
}

const Container = styled.div`
  max-width: 1300px;
  display: flex;
  flex-direction: column;
  margin: 10px auto 0;
  padding: 0 2.5rem;
  .container_button {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    p {
      margin: 10px 0 20px;
    }
    margin: 20px 0 0;
  }
  .options {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 34px 15px;
  }

  .content {
    margin-top: 70px;
    display: flex;
    flex-direction: row;
    gap: 27px;
  }

  .title {
    font-family: 'Raleway';
    font-style: normal;
    font-weight: 700;
    font-size: 20px;
    line-height: 26px;
    color: #454545;
  }
  .sub-title {
    margin-top: 43px;
    font-family: 'Raleway';
    font-style: normal;
    font-weight: 400;
    font-size: 18px;
    line-height: 30px;
    color: #000000;
  }
  .right {
    display: flex;
    flex-direction: column;
    gap: 40px;
  }
`
