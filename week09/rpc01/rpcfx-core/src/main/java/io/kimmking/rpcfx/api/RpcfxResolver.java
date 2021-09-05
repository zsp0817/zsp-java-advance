package io.kimmking.rpcfx.api;

/**
 * 解析器
 * 根据全限定类名找到对应的对象
 */
public interface RpcfxResolver {

    Object resolve(String serviceClass);

}
