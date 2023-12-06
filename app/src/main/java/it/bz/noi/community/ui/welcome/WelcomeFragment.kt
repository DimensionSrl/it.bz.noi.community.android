// SPDX-FileCopyrightText: NOI Techpark <digital@noi.bz.it>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package it.bz.noi.community.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import it.bz.noi.community.databinding.FragmentWelcomeBinding
import it.bz.noi.community.storage.updateWelcomeUnderstood
import kotlinx.coroutines.launch
import it.bz.noi.community.ui.welcome.WelcomeFragmentDirections

class WelcomeFragment : Fragment() {

	private var _binding: FragmentWelcomeBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentWelcomeBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.understood.setOnClickListener {
			lifecycleScope.launch {
				requireContext().updateWelcomeUnderstood(binding.checkbox.isChecked)
				findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToHome())
			}
		}
	}
}
