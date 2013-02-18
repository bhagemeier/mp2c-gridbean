/*********************************************************************************
 * Copyright (c) 2013 Forschungszentrum Juelich GmbH 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * (1) Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the disclaimer at the end. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution.
 * 
 * (2) Neither the name of Forschungszentrum Juelich GmbH nor the names of its 
 * contributors may be used to endorse or promote products derived from this 
 * software without specific prior written permission.
 * 
 * DISCLAIMER
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ********************************************************************************/
package eu.unicore.applications.mp2c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.intel.gpe.clients.common.transfers.Value;
import com.intel.gpe.gridbeans.parameters.EnvironmentVariableParameterValue;
import com.intel.gpe.gridbeans.parameters.IEnvironmentVariableParameterValue;
import com.intel.gpe.gridbeans.plugins.IValueTranslator;
import com.intel.gpe.gridbeans.plugins.TranslationException;
import com.intel.gpe.gridbeans.plugins.UnsupportedProtocolException;

/**
 * @author bjoernh
 * 
 *         05.02.2013 08:18:02
 * 
 */
public class IOTypeTranslator implements IValueTranslator {

	private static Map<String, String> internalToUserMap = new HashMap<String, String>();
	private static Map<String, String> userToInternalMap = new HashMap<String, String>();

	static {
		internalToUserMap.put("1", "Binary");
		internalToUserMap.put("2", "ASCII");
		internalToUserMap.put("3", "SION");
		internalToUserMap.put("4", "MPI");
		internalToUserMap.put("5", "5");
		internalToUserMap.put("6", "6");

		for (Entry<String, String> entry : internalToUserMap.entrySet()) {
			userToInternalMap.put(entry.getValue(), entry.getKey());
		}
	}

	/**
	 * Internal to user representation
	 * 
	 * @see com.intel.gpe.gridbeans.plugins.IValueTranslator#translateTo(java.lang.Object)
	 */
	@Override
	public Object translateTo(Object _internal) throws TranslationException,
			UnsupportedProtocolException {
		if (_internal == null) {
			return null;
		}

		if (_internal instanceof String) {
			final String strUser = internalToUserMap.get(_internal);
			if (strUser == null) {
				throw new TranslationException(
						"No mapping known for internal value: " + _internal);
			}
			return strUser;
		} else if (_internal instanceof IEnvironmentVariableParameterValue) {
			final String _internalString = ((IEnvironmentVariableParameterValue) _internal)
					.getVariableValue().getDisplayedString();
			final String strUser = internalToUserMap.get(_internalString);
			if (strUser == null) {
				throw new TranslationException(
						"No mapping known for internal value: " + _internal);
			}
			return strUser;
		} else {
			throw new TranslationException("Can only map Strings.");
		}
	}

	/**
	 * User to internal representation
	 * 
	 * @see com.intel.gpe.gridbeans.plugins.IValueTranslator#translateFrom(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public Object translateFrom(Object v, Object oldValue)
			throws TranslationException {
		if (v == null) {
			return null;
		}
		if (v instanceof String) {
			final String userString = (String) v;
			final String internalString = userToInternalMap.get(userString);
			if (internalString == null) {
				throw new TranslationException("No mapping for user string: "
						+ userString);
			}
			if (oldValue instanceof IEnvironmentVariableParameterValue) {
				IEnvironmentVariableParameterValue env = (IEnvironmentVariableParameterValue) oldValue;
				env = env.clone();
				env.setVariableValue(new Value(internalString));
				return env;
			} else {
				return new EnvironmentVariableParameterValue(internalString);
			}
		} else {
			throw new TranslationException("Cannot translate this.");
		}
	}

	public static String[] getInternalRepresentations() {
		return (String[]) internalToUserMap.keySet().toArray(
				new String[internalToUserMap.size()]);
	}

	public static String[] getUserRepresentations() {
		return (String[]) userToInternalMap.keySet().toArray(
				new String[userToInternalMap.size()]);
	}
}
