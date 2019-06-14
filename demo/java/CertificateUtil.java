import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.codec.Base64Encoder;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class CertificateUtil {
	private static final String KEY_STORE = "PKCS12";
	private static final String X509 = "X.509";
	private static final Map<String,KeyStore> keyStoreMap = new HashMap<String,KeyStore> ();
	private static final Map<String,Certificate> publicCer = new HashMap<String,Certificate> ();
    /**

     * 公钥证书 获取

     * @return

     * @throws Exception
     */

	public static Certificate getPublicCertificate(String certificatePath) {
		Certificate cer = publicCer.get(certificatePath);
		if (cer == null) {
			CertificateFactory certificateFactory;
			FileInputStream in = null;
			try {
				certificateFactory = CertificateFactory.getInstance(X509);
				in = new FileInputStream(certificatePath);
				Certificate certificate = certificateFactory.generateCertificate(in);
				publicCer.put(certificatePath, certificate);
				return certificate;
			} catch (CertificateException e) {
				// TODO Auto-generated catch block
				//LogsUtils.error("exceptiontofile {}",e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//LogsUtils.error("exceptiontofile {}",e);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//LogsUtils.error("exceptiontofile {}",e);
					}
				}
			}
			return null;
		} else {
			return cer;
		}

    }
	
	public static Certificate getCertificate(String certificatePath,String password)
	{

			try {
				KeyStore ks = getKeyStore(certificatePath, password);
		        Enumeration<String> en = ks.aliases();  
		        if (en.hasMoreElements()) {  
		             return ks.getCertificate(en.nextElement()); 
		        }  
			} catch (KeyStoreException e) {
				// TODO Auto-generated catch block
				//LogsUtils.error("exceptiontofile {}",e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//LogsUtils.error("exceptiontofile {}",e);
			}finally {
			}
			return null;

	}
	public static Key getPrivateKey(String certificatePath,

            String password) throws Exception {
    	KeyStore ks = getKeyStore(certificatePath, password);
        Enumeration<String> en = ks.aliases();  
        if (en.hasMoreElements()) {  
        	String keyAlias =  en.nextElement(); 
            if(ks.isKeyEntry(keyAlias))
            {
            	return ks.getKey(keyAlias, password.toCharArray());
            }
        }  
        return null;
    }
	public static PublicKey getPublicKey(Certificate cert)
            throws Exception {
        PublicKey key = cert.getPublicKey();
        return key;
    }
    private static KeyStore getKeyStore(String certificatePath,
            String password) throws Exception {
    	KeyStore keyStore = keyStoreMap.get(certificatePath+password);
		if(keyStore == null)
		{
			FileInputStream input = null;
			try {
				KeyStore ks = KeyStore.getInstance(KEY_STORE);
				input = new FileInputStream(certificatePath); 
				ks.load(input, password.toCharArray());
				keyStoreMap.put(certificatePath+password, ks);
				return ks;
			} catch (KeyStoreException e) {
				// TODO Auto-generated catch block
				//LogsUtils.error("exceptiontofile {}",e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//LogsUtils.error("exceptiontofile {}",e);
			}finally {
				if(input!= null)
				{
					try {
						input.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//LogsUtils.error("exceptiontofile {}",e);
					}
				}
			}
			return null;
		}else
		{
			return keyStore;
		}
		

    }
    /**

     * 签名

     * 

     * 

     * @return

     * @throws Exception

     */
    public static String sign(byte[] sign, X509Certificate x509Certificate,PrivateKey privateKey) throws Exception {

        Signature signature = Signature.getInstance(x509Certificate

                .getSigAlgName());

        signature.initSign(privateKey);

        signature.update(sign);

        return  Base64Encoder.encode(signature.sign());

    }
    /**

     * 验证签名

     * 

     * @param data

     * @param sign

     * @param certificatePath

     * @return

     * @throws Exception

     */

    public static boolean verify(byte[] data, String sign,

    		X509Certificate x509Certificate,PublicKey publicKey) throws Exception {
        // 构建签名
        Signature signature = Signature.getInstance(x509Certificate

                .getSigAlgName());

        signature.initVerify(publicKey);

        signature.update(data);
        return signature.verify(Base64Decoder.decode(sign));
    }
    
    /**

     * 公钥加密

     * 

     * @param data

     * @param publicKey

     * @return

     * @throws Exception

     */

    public static byte[] encryptByPublicKey(byte[] data, PublicKey publicKey)

            throws Exception {
        // 对数据加密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }
    /**

     * 私钥解密

     * @param data

     * @param certificatePath

     * @param password

     * @return

     * @throws Exception

     */

    public static byte[] decryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }
    /**

     * 公钥加密

     * 

     * @param data

     * @param certificatePath
     * @param password

     * @return

     * @throws Exception

     */

    public static byte[] encryptByPublicKey(byte[] data, String certificatePath,String password)

            throws Exception {
        // 取得公钥
        PublicKey publicKey = getPublicKey(getCertificate(certificatePath,password));
        // 对数据加密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }
    /**

     * 私钥解密

     * @param data

     * @param certificatePath

     * @param password

     * @return

     * @throws Exception

     */

    public static byte[] decryptByPrivateKey(byte[] data, String certificatePath,String password) throws Exception {
        // 取得私钥
        PrivateKey privateKey = (PrivateKey) getPrivateKey(certificatePath, password);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }
    /**

     * 签名

     * 

     * @param keyStorePath

     * @param alias

     * @param password

     * 

     * @return

     * @throws Exception

     */

    public static String sign(byte[] sign, String certificatePath,

            String password) throws Exception {

        // 获得证书
        X509Certificate x509Certificate = (X509Certificate) getCertificate(
        		certificatePath, password);
        // 取得私钥
        PrivateKey privateKey = (PrivateKey) getPrivateKey(certificatePath, password);
        Signature signature = Signature.getInstance(x509Certificate

                .getSigAlgName());
        signature.initSign(privateKey);
        signature.update(sign);
        return  Base64Encoder.encode(signature.sign());

    }
    /**

     * 验证签名

     * 

     * @param data

     * @param sign

     * @param certificatePath

     * @return

     * @throws Exception

     */

    public static boolean verify(byte[] data, String sign,

            String certificatePath) throws Exception {
        // 获得证书
        X509Certificate x509Certificate = (X509Certificate) getPublicCertificate(certificatePath);
        // 获得公钥
        PublicKey publicKey = x509Certificate.getPublicKey();
        Signature signature = Signature.getInstance(x509Certificate
                .getSigAlgName());
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(Base64Decoder.decode(sign));
    }
    /**

     * 公钥解密

     * 

     * @param data

     * @param certificatePath

     * @return

     * @throws Exception

     */

    public static byte[] decryptByPublicKey(byte[] data, String certificatePath)

            throws Exception {
        // 获得证书
        X509Certificate x509Certificate = (X509Certificate) getPublicCertificate(certificatePath);
        // 取得公钥
        PublicKey publicKey = x509Certificate.getPublicKey();
        // 对数据解密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }    
}
