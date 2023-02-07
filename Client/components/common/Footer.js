import styled from 'styled-components'
import Link from 'next/link'
import  IcoInstagram from '@/public/icons/Instagram'
import  IcoFace from '@/public/icons/Facebook'
import  IcoYoutube from '@/public/icons/Youtube'
import  IcoTik from '@/public/icons/Tiktok'

export const Footer = () => {
  return(
    <FooterContainer>
      
      <div className='container'>
        <Item1>
          <h6  className='title'> Contáctanos!</h6>
          &nbsp;
          <Link href="#">
            <p>Remedios de Escalada de San Martin 3875</p>
            <p>Floresta(CABA)</p>
          </Link>
          <br/> 
          <Link href='#'>            
            <p>Florida537 PB, Local 379</p>
            <p>Microcentro (CABA)</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Whatsaap: +54 11 2357-5588</p>
          </Link>
          <br/>
          <a href='mailito:empresas@maximus.com.ar'>empresas@maximus.com.ar</a>
        </Item1>
        <Item2>
          <h6 className='title'>Nuestros Horarios</h6>
          &nbsp;
          <Link href='#'>
            <p>Floresta<br/>
            Lun a Vie. 9:00 AM 18:00PM<br/>
            Sab 10:00 AM - 14:30PM.</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Florida Local<br/>
            Lun a Vier, 10:00 AM a 19:00 PM<br/>
            Sab 10:00 AM - 14:30 PM</p>
          </Link>
        </Item2>
        <Item3>
          <h6 className='title'>Ayuda</h6>
          &nbsp;
          <Link href='#'>
            <p>FAQ</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Trámite Garantía</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Boton de Arrepentimiento</p>
          </Link>
        </Item3>
        <Item4>
          <h6 className='title'>Seguinos en las Redes</h6>
          
          <Link href='#'>
            <IcoInstagram />          
          </Link>
          <Link href='#'>
            <IcoFace />
          </Link>
          <Link href='#'>
            <IcoYoutube />
          </Link>
          <Link href='#'>
            <IcoTik />
          </Link>
        </Item4>
        <Item5>
          
        </Item5>
      </div>

    </FooterContainer>
  )
}

const FooterContainer = styled.div`
  background-color: var(--secondaryViolet1);
  width: 100%;
  color: white;
  padding: 2rem 0;
  margin-top: 10rem;
  .container{
    display: flex;
    justify-content: center;
    gap: 40px;
    font-size: 12px;

  }
 `
const Item1 = styled.div` 
  .title {
    font-style: italic;
    color: var(--primaryGreen2);
  }
  p:hover{
    color:var(--primaryGreen2)
  }
  a:hover{
    color:var(--primaryGreen2)
  }
`
const Item2 = styled.div`
  .title{
    font-style: italic;
    color: var(--primaryGreen2);
  }
  p:hover{
    color:var(--primaryGreen2)
  }
`
const Item3 = styled.div`
  .title{
    font-style: italic;
    color: var(--primaryGreen2);
  }
  p:hover{
    color:var(--primaryGreen2)
  }
`
const Item4 = styled.div`
  .title{
    font-style: italic;
    color: var(--primaryGreen2);
  }
`
const Item5 = styled.div`
  .title{
    font-style: italic;
    color: var(--primaryGreen2);
  }
`