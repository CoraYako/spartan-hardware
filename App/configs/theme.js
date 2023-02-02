import { createGlobalStyle } from 'styled-components'
import global from './global'
import resetCSS from './reset-css'
import textStyles from './text-styles'

const GlobalStyles = createGlobalStyle`
  ${global}
  ${resetCSS}
  ${textStyles}
`
export default GlobalStyles
