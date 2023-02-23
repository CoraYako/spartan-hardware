import styled from 'styled-components'
import Link from 'next/link'
import IcoInstagram from '@/public/icons/Instagram'
import IcoFace from '@/public/icons/Facebook'
import IcoYoutube from '@/public/icons/Youtube'
import IcoTik from '@/public/icons/Tiktok'

export const Footer = () => {
  return (
    <FooterContainer>
      <div className="container">
        <Item>
          <h2 className="title"> Contáctanos!</h2>
          &nbsp; &nbsp;
          <Link href="https://goo.gl/maps/ee8VUcUW2sCa14XQ6">
            <p>Remedios de Escalada de San Martin 3875</p>
            <p>
              <br />
            </p>
            <p>Floresta(CABA)</p>
            <p>
              <br />
            </p>
          </Link>
          <Link href="https://goo.gl/maps/bTbq5mB3SZBayFGZA">
            <p>Florida 537 PB, Local 379</p>
            <p>
              <br />
            </p>
            <p>Microcentro (CABA)</p>
          </Link>
          <Link href="#">
            <p>
              <br />
            </p>
            <p>Whatsaap: +54 11 2357-5588</p>
            <p>
              <br />
            </p>
          </Link>
          <p>
            <a href="mailto:empresas@maximus.com.ar">empresas@maximus.com.ar</a>
          </p>
        </Item>
        <Item>
          <h2 className="title">Nuestros Horarios</h2>
          &nbsp; &nbsp;
          <Link href="#">
            <p> Floresta Lun a Vie. 9:00 AM 18:00PM</p>
            <p>
              <br />
            </p>
            <p>Sab 10:00 AM - 14:30PM.</p>
          </Link>
          <br />
          <Link href="#">
            <p>Florida Local Lun a Vier, 10:00 AM a 19:00 PM</p>
            <p>
              <br />
            </p>
            <p>Sab 10:00 AM - 14:30 PM</p>
          </Link>
        </Item>
        <Item>
          <h2 className="title">Ayuda</h2>
          &nbsp; &nbsp;
          <Link href="#">
            <p>FAQ</p>
          </Link>
          <p>
            <br />
          </p>
          <Link href="#">
            <p>Trámite Garantía</p>
          </Link>
          <p>
            <br />
          </p>
          <Link href="#">
            <p>Boton de Arrepentimiento</p>
          </Link>
        </Item>
        <Item>
          <h2 className="title">Seguinos en las Redes</h2>
          <br />
          <p>Consulta mas sobre nosotros, nuestros productos</p>
          <p>
            <br />
          </p>
          <p>Y contenido adicional en nuestras resdes sociales</p>
          <p>
            <br />
          </p>
          <Link className="face" href="#">
            <IcoFace />
          </Link>
          <Link className="inst" href="#">
            <IcoInstagram />
          </Link>
          <Link href="#">
            <IcoTik />
          </Link>
          <Link className="inst" href="#">
            <IcoYoutube />
          </Link>
        </Item>
      </div>
    </FooterContainer>
  )
}

const FooterContainer = styled.div`
  background-color: var(--black);
  width: 100%;
  color: white;
  padding: 5rem 0;
  left: -1px;
  margin-top: 5rem;
  .container {
    margin-left: 2em;
    margin-right: 2em;
    margin-bottom: 4rem;
    margin-top: -1rem;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    gap: 5em;
  }
`
const Item = styled.div`
  .title {
    font-size: 20px;
    color: var(--primaryGreen1);
  }
  p {
    font-size: 12px;
  }
  p:hover {
    color: var(--primaryGreen1);
  }
  a {
    font-size: 12px;
  }
  a:hover {
    color: var(--primaryGreen1);
  }
  .inst:hover {
    color: red;
  }
  .face:hover {
    color: blue;
  }
`
