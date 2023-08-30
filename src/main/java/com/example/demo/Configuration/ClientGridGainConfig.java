//package com.example.demo.Configuration;
//
//import org.apache.ignite.Ignite;
//import org.apache.ignite.IgniteCache;
//import org.apache.ignite.Ignition;
//import org.apache.ignite.cache.CacheMode;
//import org.apache.ignite.cache.CacheRebalanceMode;
//import org.apache.ignite.configuration.CacheConfiguration;
//import org.apache.ignite.configuration.IgniteConfiguration;
//import org.apache.ignite.plugin.security.SecurityCredentials;
//import org.apache.ignite.plugin.security.SecurityCredentialsBasicProvider;
//import org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi;
//import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
//import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
//import org.apache.ignite.ssl.SslContextFactory;
//import org.gridgain.grid.configuration.GridGainConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Collections;
//
//@Configuration
//public class ClientGridGainConfig {
//
//    @Bean
//    public Ignite igniteConfiguration(){
//        System.setProperty("IGNITE_EVENT_DRIVEN_SERVICE_PROCESSOR_ENABLED", "true");
//        SecurityCredentials clientCredentials = new SecurityCredentials("cluster-user", "Ravindra@1");
//
//        CacheConfiguration cacheCfg=new CacheConfiguration("myCache");
////        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
////        cacheCfg.setBackups(2);
//       // cacheCfg.setRebalanceMode(CacheRebalanceMode.SYNC);
//
//        IgniteConfiguration cfg = new IgniteConfiguration()
//                .setClientMode(true)
//                .setDiscoverySpi(new TcpDiscoverySpi()
//                        .setIpFinder(new TcpDiscoveryVmIpFinder()
//                                .setAddresses(Collections.singleton("137ce34d-d21d-4f72-9d01-2f7fb75bb34c.nebula-shared-us-east-1.nebula.gridgain.com:47500"))))
//                .setCommunicationSpi(new TcpCommunicationSpi()
//                        .setForceClientToServerConnections(true))
//                .setPluginConfigurations(new GridGainConfiguration()
//                        .setSecurityCredentialsProvider(new SecurityCredentialsBasicProvider(clientCredentials))
//                        .setRollingUpdatesEnabled(true))
//                .setSslContextFactory(new SslContextFactory())
//                .setCacheConfiguration(cacheCfg);
//
//        return Ignition.start(cfg);
//    }
//
//    @Bean
//
//    public IgniteCache<Long,String> cache(Ignite ignite)
//    {
//        CacheConfiguration<Long,String> cacheConfiguration=new CacheConfiguration<>("myCache");
//        return ignite.getOrCreateCache(cacheConfiguration);
//    }
//
//
//}
