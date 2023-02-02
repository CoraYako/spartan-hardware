//Dependencies
import { QueryClientProvider, QueryClient } from 'react-query'
//Styles
import GlobalStyles from '@/configs/theme'
import '@/styles/globals.css'
//Context
import GlobalContextProvider from '@/context/GlobalContext'
//Components
import Layout from '@/components/common/Layout'

export default function App({ Component, pageProps }) {
  const queryClient = new QueryClient()

  return (
    <GlobalContextProvider>
      <QueryClientProvider client={queryClient}>
        <GlobalStyles />
        <Layout>
          <Component {...pageProps} />
        </Layout>
      </QueryClientProvider>
    </GlobalContextProvider>
  )
}
