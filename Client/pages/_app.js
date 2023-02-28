//Dependencies
import { QueryClientProvider, QueryClient } from 'react-query'
//Styles
import GlobalStyles from '@/configs/theme'
import '@/styles/globals.css'
//Context
import GlobalContextProvider from '@/context/GlobalContext'
//Components
import Layout from '@/components/common/Layout'
import UserContextProvider from '@/context/UserContext'

export default function App({ Component, pageProps }) {
  const queryClient = new QueryClient()

  return (
    <GlobalContextProvider>
      <UserContextProvider>
        <QueryClientProvider client={queryClient}>
          <GlobalStyles />
          <Layout>
            <Component {...pageProps} />
          </Layout>
        </QueryClientProvider>
      </UserContextProvider>
    </GlobalContextProvider>
  )
}
